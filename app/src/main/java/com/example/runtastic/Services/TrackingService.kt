package com.example.runtastic.Services

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.ContentProviderClient
import android.content.Context
import android.content.Intent
import android.location.Location
import android.os.Build
import android.os.Looper
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.runtastic.R
import com.example.runtastic.Services.TrackingService.Companion.isTracking
import com.example.runtastic.db.other.Constants.ACTION_PAUSE_SERVICE
import com.example.runtastic.db.other.Constants.ACTION_SHOW_TRACKING_FRAGMENT
import com.example.runtastic.db.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runtastic.db.other.Constants.ACTION_STOP_SERVICE
import com.example.runtastic.db.other.Constants.FASTEST_lOCATION_INTERVAL
import com.example.runtastic.db.other.Constants.LOCATION_UPDATE_INTERVAL
import com.example.runtastic.db.other.Constants.NOTIFICATION_CHANNEL_ID
import com.example.runtastic.db.other.Constants.NOTIFICATION_CHANNEL_NAME
import com.example.runtastic.db.other.Constants.NOTIFICATION_ID
import com.example.runtastic.db.other.TrackingUtility
import com.example.runtastic.ui.MainActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationRequest.PRIORITY_HIGH_ACCURACY
import com.google.android.gms.location.LocationResult
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber


typealias  PolyLine = MutableList<LatLng>
typealias  Polylines = MutableList<PolyLine>
class TrackingService : LifecycleService() {

    var isFirstRun = true
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    private val timeRunInSeconds = MutableLiveData<Long>()


    //Variables that can be access wherever within the class
    companion object {
        val timeRunInMilis = MutableLiveData<Long>()
        val isTracking = MutableLiveData<Boolean>()
        val pathPoints = MutableLiveData<Polylines>()

    }


    //Stores initial values
    private fun postInitialValues(){
        isTracking.postValue(false)
        pathPoints.postValue(mutableListOf())

    }

    //OnCreate, the camera zooms in on the User, the initial values are sent to the DB. The main entry point to talk to location provider
    override fun onCreate() {
        super.onCreate()
        fusedLocationProviderClient = FusedLocationProviderClient(this)
        postInitialValues()

        isTracking.observe(this, Observer {
            updateLocationTracking(it)
        })
    }


    //Once the start button is pressed, the foreground service starts running, it checks if it is the first run of the user and the camera follows the user.
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ACTION_START_OR_RESUME_SERVICE -> {
                    if(isFirstRun){
                        startForegroundService()
                        isFirstRun = false
                    } else{
                        Timber.d("Resuming service")
                        startForegroundService()
                    }

                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Paused service")
                    pauseService()
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }




    //Variables to be called latter within the class
    private var isTimerEnabled = false
    private var lapTime = 0L
    private var timeRun = 0L
    private var timeStarted = 0L
    private var lastSecondTimeStamp = 0L


    //Whenever we start the timer we need to add an empty polyline. Also setting the isTracking service to true.
    // Getting the current time in miliseconds
    //Time is enabled = true.
    //As long as we're tracking we will execute the while loop and keep tracking the time
    private fun startTimer(){
        addEmptyPolyline()
        isTracking.postValue(true)
        timeStarted = System.currentTimeMillis()
        isTimerEnabled = true
        CoroutineScope(Dispatchers.Main).launch {
            while (isTracking.value!!) {
                //Time difference between now and when the counter started
                lapTime = System.currentTimeMillis() - timeStarted
                //Posts new laptime (which is equal to the total time)
                timeRunInMilis.postValue(timeRun + lapTime)
                if(timeRunInMilis.value!! >= lastSecondTimeStamp + 1000L){

                }
            }
        }
    }



    //On pause, the tracking service is suspended, but the current value is stored in the DB
    private fun pauseService(){
        isTracking.postValue(false)
    }




    //This is a service that locates the user, every few seconds(defined in the Constants::class.java), zooms the camera and follows the user.
    @SuppressLint("MissingPermission")
    private fun updateLocationTracking(isTracking: Boolean){
        if(isTracking == true) {
            if(TrackingUtility.hasLocationPermission(this)){
                val request= LocationRequest().apply {
                    interval = LOCATION_UPDATE_INTERVAL
                    fastestInterval = FASTEST_lOCATION_INTERVAL
                    priority = PRIORITY_HIGH_ACCURACY
                }
                fusedLocationProviderClient.requestLocationUpdates(
                    request,
                    locationCallback,
                    Looper.getMainLooper()
                )
            }
        } else {
            fusedLocationProviderClient.removeLocationUpdates(locationCallback)
        }
    }



    //This function sends the current location to the service, so it can draw the line and count the kms ran.
    val locationCallback = object : LocationCallback(){
        override fun onLocationResult(result: LocationResult?) {
            super.onLocationResult(result)

            if(isTracking.value!!){
                result?.locations?.let {
                    locations ->
                    for(location in locations) {
                        addPathPoint(location)
                        Timber.d("New Location ${location.latitude}, ${location.longitude}")
                    }
                }
            }
        }
    }


    //This function adds a polyline, to connect the dots where the user has been.
    private fun addPathPoint(location: Location?){
        location?.let {
            val position = LatLng(location.latitude, location.longitude)
            pathPoints.value?.apply {
                last().add(position)
                pathPoints.postValue(this)
            }
        }
    }


    //Adds empty polyline whenever the users pauses the run, keeps walking and later resumes it, a few meters on the go.
    private fun addEmptyPolyline() = pathPoints.value?.apply {
        add(mutableListOf())
        pathPoints.postValue(this)
    } ?: pathPoints.postValue(mutableListOf(mutableListOf()))




    /*A service is an android application component that can perform long running operations in the background
    * A foreground service performs some sort of operation that is noticeable to the user.
    * In this case, our foreground service, displays a notification that shows the current run time, the apps name, a pause and a resume button, and whenever it is pressed
    * it will open the app on the Run fragment.*/
    private fun startForegroundService(){

        isTracking.postValue(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE)
        as NotificationManager

        if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            createNotificationChannel(notificationManager)
        }


        //Defines the layout for the notification
        val notificationBuilder = NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
            //When the user clicks on the notifications, it disappears, this makes it always show.
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black)
            .setContentTitle("Runner")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(NOTIFICATION_ID, notificationBuilder.build())
    }


    //A pending intent, is a process that, if used by other functions will remain usable, even if its killed by the main process.
    //When the pending activity is called with the getActivity(), it opens that activity once the notification is clicked.
    //Onclick of the Notification it opens the Main Activity.
    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    //A notificationManager is a class to notify the users of events that happen. This is how you tell the users that something has happened in the background
    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(NOTIFICATION_CHANNEL_ID,
            NOTIFICATION_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}
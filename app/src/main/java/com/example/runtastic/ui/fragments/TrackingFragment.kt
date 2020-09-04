package com.example.runtastic.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.runtastic.R
import com.example.runtastic.Services.PolyLine
import com.example.runtastic.Services.TrackingService
import com.example.runtastic.db.other.Constants.ACTION_PAUSE_SERVICE
import com.example.runtastic.db.other.Constants.ACTION_START_OR_RESUME_SERVICE
import com.example.runtastic.db.other.Constants.MAP_ZOOM
import com.example.runtastic.db.other.Constants.POLYLINE_COLOR
import com.example.runtastic.db.other.Constants.POLYLINE_WIDTH
import com.example.runtastic.ui.viewmodels.MainViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.model.PolylineOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_tracking.*

@AndroidEntryPoint
class TrackingFragment: Fragment(R.layout.fragment_tracking) {

    //A viewmodel is a class that is reponsible for managing and preparing data for an activity.
    private val viewModel: MainViewModel by viewModels()
    private var isTracking = false
    private var pathPoints = mutableListOf<PolyLine>()


    private var map: GoogleMap? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mapView.onCreate(savedInstanceState)
        btnToggleRun.setOnClickListener{
            toggleRun()

        }
        mapView.getMapAsync {
            map = it
            addAllPolylines()
        }
        subscribeToObservers()

    }


    //This function observes the tracking service, adds the latest pathpoints, polyline and helps the camera following the user.
    private fun subscribeToObservers() {
        TrackingService.isTracking.observe(viewLifecycleOwner, Observer {
            updateTracking(it)
        })

        TrackingService.pathPoints.observe(viewLifecycleOwner, Observer {
            pathPoints = it
            addLatestPolyline()
            moveCameraToUser()
        })
    }


    //This function toggles the running service, when the button is clicked, if the tracking service is running and the user is paused, else it starts the run.
    private fun toggleRun() {
        if(isTracking){
            sendCommandToService(ACTION_PAUSE_SERVICE)
        } else {
            sendCommandToService(ACTION_START_OR_RESUME_SERVICE)
        }
    }



    //This function uses the isTracking service to check if the user is on a run, in case if it's not, the start button becomes visible, on the other, if he's
    // already running, the start buttons visibility becomes GONE and the stop button becomes visible.
    private fun updateTracking(isTracking: Boolean){
        this.isTracking = isTracking
        if(!isTracking){
            btnToggleRun.text =  "Start"
            btnFinishRun.visibility = View.VISIBLE
        } else{
            btnToggleRun.text = "Stop"
            btnFinishRun.visibility = View.GONE
        }
    }

    //Moves camera to the user whenever a new action is detected.
    private fun moveCameraToUser(){
        if(pathPoints.isNotEmpty() && pathPoints.last().isNotEmpty()) {
            map?.animateCamera(
                CameraUpdateFactory.newLatLngZoom(
                    pathPoints.last().last(),
                    MAP_ZOOM
                )
            )
        }
    }



    //Connects all the dots in the polylines.
    private fun addAllPolylines() {
        for(polyline in pathPoints) {
            val polylineOptions = PolylineOptions()
                .color(POLYLINE_COLOR)
                .width(POLYLINE_WIDTH)
                .addAll(polyline)
            map?.addPolyline(polylineOptions)
        }
    }


    //Defines the polyline's attributes, such as color and width. Defines the polyline form.
    private fun addLatestPolyline(){
        if(pathPoints.isNotEmpty() && pathPoints.last().size > 1){
            val preLastLatLng = pathPoints.last()[pathPoints.last().size - 2]
            val lastLatLong = pathPoints.last().last()
            val polylineOptions = PolylineOptions()
                .color(POLYLINE_COLOR)
                .width(POLYLINE_WIDTH)
                .add(preLastLatLng)
                .add(lastLatLong)
            map?.addPolyline(polylineOptions)

        }
    }


    // Starts the tracking, (to be called on the button click).
    private fun sendCommandToService(action:String) = Intent(requireContext(), TrackingService::class.java).also{
    it.action = action
        requireContext().startService(it)
    }


    override fun onResume() {
        super.onResume()

        mapView?.onResume()
    }


    override fun onStart() {
        super.onStart()

        mapView?.onStart()
    }

    override fun onPause() {
        super.onPause()
        mapView?.onPause()
    }

    override fun onStop() {
        super.onStop()
        mapView?.onStop()
    }


    //Checks if the device is on low memory
    override fun onLowMemory() {
        super.onLowMemory()
        mapView?.onLowMemory()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        mapView?.onSaveInstanceState(outState)
    }
}
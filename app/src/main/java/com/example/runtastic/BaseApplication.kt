package com.example.runtastic

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

//Tells the app to use Dagger as the Independency injector.
@HiltAndroidApp
class BaseApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}
package com.example.runtastic.db.other

import android.content.Context
import android.os.Build
import pub.devrel.easypermissions.EasyPermissions
import java.util.jar.Manifest

object TrackingUtility {

    fun hasLocationPermission(context: Context) =
        if(Build.VERSION.SDK_INT <  Build.VERSION_CODES.Q) {
            EasyPermissions.hasPermissions(context,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION)
        } else {
            EasyPermissions.hasPermissions(context,
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION)

        }
}
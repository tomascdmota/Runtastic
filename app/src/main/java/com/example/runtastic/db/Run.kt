package com.example.runtastic.db

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "running_table")
data class Run (
    var img: Bitmap? = null,
    var timestamp: Long = 0L, // Amount of miliseconds, date of run converted into miliseconds
    var averageSpeedInKmh: Float = 0f,
    var distanceMeters: Int = 0,
    var timeInMilis: Long = 0L,
    var caloriesBurnt: Int = 0
){
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}
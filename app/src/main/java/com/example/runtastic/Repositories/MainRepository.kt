package com.example.runtastic.Repositories

import com.example.runtastic.db.Run
import com.example.runtastic.db.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunsSortedByDate() = runDao.getAllRunsSortedByData()

    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()

    fun getAllRunsSortedByTimeInMili() = runDao.getAllRunsSortedByTimeInMili()

    fun getAllRunsSortedByAverageSpeed() = runDao.getAllRunsSortedByAverageSpeed()

    fun getAllRunsSortedByCaloriesBurnt() = runDao.getAllRunsSortedByCaloriesBurnt()

    fun getTotalAverageSpeed()= runDao.getTotalAverageSpeedKmh()

    fun getTotalDistance() = runDao.getTotalDistanceInMeters()

    fun getTotalCaloriesBurnt() = runDao.getTotalCaloriesBurnt()

    fun getTotalTimeInMilis() = runDao.getTotalTimeInMili()



}
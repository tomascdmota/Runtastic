package com.example.runtastic.db

import androidx.lifecycle.LiveData
import androidx.room.*


//Data Access Object
@Dao
interface RunDao {

    //Function to a run to the DB, also replaces if there already exists an equal one there.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRun(run: Run)

    //Function to delete a file on the DB.
    @Delete
    suspend fun deleteRun(run: Run)

    //Database query that provides a query from the db, this query is selecting the table_name, from Run.kt;
    @Query("SELECT * FROM running_table ORDER BY timestamp DESC")
    fun getAllRunsSortedByData(): LiveData<List<Run>>

    //This query returns all of the queries, in miliseconds.
    @Query("SELECT * FROM running_table ORDER BY timeInMilis DESC")
    fun getAllRunsSortedByTimeInMili(): LiveData<List<Run>>

    //This query returns all of the calories burnt
    @Query("SELECT * FROM running_table ORDER BY caloriesBurnt DESC")
    fun getAllRunsSortedByCaloriesBurnt(): LiveData<List<Run>>

    //This query returns the average Speed
    @Query("SELECT * FROM running_table ORDER BY averageSpeedInKmh DESC")
    fun getAllRunsSortedByAverageSpeed(): LiveData<List<Run>>

    //This query returns the distance in Meters
    @Query("SELECT * FROM running_table ORDER BY distanceMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>



    //Its a long value, because Miliseconds are always displayed as a Long.
    @Query("SELECT SUM(timeInMilis) FROM running_table")
    fun getTotalTimeInMili(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurnt) FROM running_table")
    fun getTotalCaloriesBurnt(): LiveData<Int>

    @Query("SELECT SUM(distanceMeters) FROM running_table")
    fun getTotalDistanceInMeters(): LiveData<Int>

    @Query("SELECT AVG(averageSpeedInKmh) FROM running_table")
    fun getTotalAverageSpeedKmh(): LiveData<Float>



}
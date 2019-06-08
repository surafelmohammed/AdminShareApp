package com.example.surafel.kotlineshareapp.LocalDB

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ReportedDataDao{

    @Query("SELECT * FROM fileReport WHERE report = 'true' ")
    fun getAllReportedData():LiveData<List<ReportedData>>

    @Delete
    fun deleteFileById(file: ReportedData)

    @Query("UPDATE fileReport SET report = 'false' WHERE fileId=:id")
    fun removeReport(id:Int)

    @Insert
    fun addReportFile(file: ReportedData)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateReportText(file: ReportedData)

}
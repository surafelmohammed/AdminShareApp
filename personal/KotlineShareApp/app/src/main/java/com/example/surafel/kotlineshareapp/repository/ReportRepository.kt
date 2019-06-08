package com.example.surafel.kotlineshareapp.repository

import androidx.lifecycle.LiveData
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.LocalDB.ReportedDataDao

class ReportRepository(private val reportDao: ReportedDataDao) {

    fun allReports():LiveData<List<ReportedData>> = reportDao.getAllReportedData()

    fun deleteFile(file: ReportedData){
        return reportDao.deleteFileById(file)
    }

    fun removeReport(id:Int) {
        return reportDao.removeReport(id)
    }

    fun addReportFile(file: ReportedData) {
        return reportDao.addReportFile(file)
    }
    fun updateReport(file: ReportedData){
        return reportDao.updateReportText(file)
    }
}
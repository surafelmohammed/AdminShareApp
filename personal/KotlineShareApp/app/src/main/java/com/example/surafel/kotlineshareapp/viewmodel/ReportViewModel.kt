package com.example.surafel.kotlineshareapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.surafel.kotlineshareapp.LocalDB.ReportDatabase
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.repository.ReportRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ReportViewModel(application: Application) : AndroidViewModel(application) {
    private val reportRepository: ReportRepository
    val allReportData:LiveData<List<ReportedData>>

    init {
        val reportDao = ReportDatabase.getDatabase(application).getDao()
        reportRepository = ReportRepository(reportDao)
        allReportData = reportRepository.allReports()
    }

    fun deleteFile(file: ReportedData)=viewModelScope.launch(Dispatchers.IO){
        reportRepository.deleteFile(file)
    }

    fun removeReport(id:Int) = viewModelScope.launch(Dispatchers.IO){
        reportRepository.removeReport(id)
    }
    fun addReportFile(file: ReportedData) = viewModelScope.launch(Dispatchers.IO){
        reportRepository.addReportFile(file)
    }
    fun updataReport(file: ReportedData) = viewModelScope.launch(Dispatchers.IO){
        reportRepository.updateReport(file)
    }
}
package com.example.surafel.kotlineshareapp.repository

import androidx.lifecycle.LiveData
import com.example.surafel.kotlineshareapp.LocalDB.ReportedData
import com.example.surafel.kotlineshareapp.LocalDB.ReportedDataDao
import com.example.surafel.kotlineshareapp.network.NetworkData
import com.example.surafel.kotlineshareapp.network.ReportApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.Response
import retrofit2.Call

class ReportRepository(private val reportDao: ReportedDataDao,val ApiService:ReportApiService) {

    fun allReports():LiveData<List<ReportedData>> = reportDao.getAllReportedData()
    fun deleteFile(file: ReportedData)=reportDao.deleteFileById(file)
    fun removeReport(id:Int) =reportDao.removeReport(id)
    fun addReportFile(file: ReportedData) =reportDao.addReportFile(file)
    fun updateReport(file: ReportedData)=reportDao.updateReportText(file)

    suspend fun getReportById(id: Int): Call<NetworkData> =
        withContext(Dispatchers.IO){
            ApiService.findResponseById(id)
        }
    suspend fun getAllReport(): Call<List<NetworkData>> =
        withContext(Dispatchers.IO){
            ApiService.findAllResponse()
        }
    suspend fun updatePost(id: Int, data:NetworkData) =
        withContext(Dispatchers.IO){
            ApiService.updataReport(data)
        }
    suspend fun deletePost(id: Int) = withContext(Dispatchers.IO){
            ApiService.deleteReport(id)
        }
}
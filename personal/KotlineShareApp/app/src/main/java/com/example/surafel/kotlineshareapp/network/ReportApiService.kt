package com.example.surafel.kotlineshareapp.network

import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.surafel.kotlineshareapp.network.NetworkData as NetworkData1

interface ReportApiService {

    @GET("posts")
    fun findAllResponse(): Call<List<com.example.surafel.kotlineshareapp.network.NetworkData>>

    @GET("posts")
    fun findResponseById(id:Int): Call<com.example.surafel.kotlineshareapp.network.NetworkData>

    @DELETE("posts/{id}")
    fun deleteReport(@Path("id") id: Int)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updataReport(report:com.example.surafel.kotlineshareapp.network.NetworkData)

    companion object {

        private val baseUrl = "https://jsonplaceholder.typicode.com/"

        fun getInstance(): ReportApiService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BASIC
            val client = OkHttpClient
                .Builder()
                .addInterceptor(interceptor)
                .build()
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(ReportApiService::class.java)
        }
    }
}
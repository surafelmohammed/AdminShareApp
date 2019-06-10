package com.example.surafel.kotlineshareapp.network

import java.io.Serializable

data class NetworkData(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
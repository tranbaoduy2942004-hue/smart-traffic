package com.example.smarttraffic.model

data class TrafficSign(
    val id: Int,
    val code: String,
    val name: String,
    val description: String,
    val group: String,
    val imageResId: Int
)
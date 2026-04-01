package com.example.smarttraffic.model

data class TrafficSign(
    val id: Int,
    val code: String,
    val name: String,
    val description: String,
    val category: String,
    val imageResId: Int
)
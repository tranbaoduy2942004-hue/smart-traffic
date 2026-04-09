package com.example.smarttraffic.network

import com.example.smarttraffic.dto.LawCategoryDto
import com.example.smarttraffic.dto.LawDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface LawApiService {

    @GET("api/laws/categories")
    fun getCategories(): Call<List<LawCategoryDto>>

    @GET("api/laws/category/{categoryId}")
    fun getLawsByCategory(@Path("categoryId") categoryId: Int): Call<List<LawDto>>

    @GET("api/laws/{id}")
    fun getLawById(@Path("id") id: Int): Call<LawDto>
}
package com.mikelo04.apiaplication.api

import com.mikelo04.apiaplication.response.ResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser(): Call<ArrayList<ResponseModel>>
}
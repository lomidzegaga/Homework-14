package com.example.homework_14.api

import com.example.homework_14.constants.Constants
import com.example.homework_14.model.MainDataClass
import retrofit2.Response
import retrofit2.http.GET

interface GetItems {
    @GET(Constants.END_POINT)
    suspend fun items() : Response<MainDataClass>
}
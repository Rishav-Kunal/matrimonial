package com.rishav.matrimonialapp.network

import com.rishav.matrimonialapp.data.RandomUserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {
    @GET("/api/")
    suspend fun getMatches(
        @Query("results") results: Int = 10
    ) : Response<RandomUserResponse>
}
package com.example.somename.data

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApi {

    @GET("users")
    suspend fun getUsers(@Query("since") offset: Int, @Query("per_page") limit: Int)


    @GET("users/{userName}")
    suspend fun getSingleUser(@Path("userName") name: String)
}
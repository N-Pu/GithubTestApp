package com.example.somename.data

import com.example.somename.model.ListUser
import com.example.somename.model.SingleUser
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    @GET("users")
     fun getUsers(
        @Query("since") offset: Int,
        @Query("per_page") limit: Int
    ): Call<List<ListUser>>


    @GET("users/{userName}")
     fun getSingleUser(@Path("userName") name: String): Call<SingleUser>
}
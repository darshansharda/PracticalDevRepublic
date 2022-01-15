package com.devrepublic.practical.api

import com.devrepublic.practical.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {

    @GET("top-headlines")
    suspend fun getMovieData(@QueryMap param: HashMap<String, String>): NewsModel
}
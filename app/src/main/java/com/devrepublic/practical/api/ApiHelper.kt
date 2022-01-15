package com.devrepublic.practical.api

import com.devrepublic.practical.model.NewsModel

interface ApiHelper {
    suspend fun getMovieData(param: HashMap<String, String>): NewsModel
}
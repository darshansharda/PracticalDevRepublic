package com.devrepublic.practical.api

class ApiHelperImpl(private val apiService: ApiService) : ApiHelper {
    override suspend fun getMovieData(param: HashMap<String, String>) = apiService.getMovieData(param)
}
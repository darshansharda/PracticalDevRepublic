package com.devrepublic.practical.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devrepublic.practical.api.ApiHelper
import com.devrepublic.practical.api.ApiHelperImpl
import com.devrepublic.practical.api.Resource
import com.devrepublic.practical.api.RetrofitBuilder
import com.devrepublic.practical.model.ArticlesModel
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val apiHelper: ApiHelper = ApiHelperImpl(RetrofitBuilder.apiService)
    private val newsFeeds = MutableLiveData<Resource<List<ArticlesModel>>>()
    fun getNewsFeeds(): LiveData<Resource<List<ArticlesModel>>> = newsFeeds

    init {
        getNews()
    }

    private fun getNews() {

        viewModelScope.launch {
            newsFeeds.postValue(Resource.loading())
            try {
                val param = HashMap<String, String>()
                param["country"] = "in"
                param["apiKey"] = "33042fb5a760466198c8ae7446eb46a8"
                val response = apiHelper.getMovieData(param)
                newsFeeds.postValue(Resource.success(response.articles))
            } catch (e: Exception) {
                newsFeeds.postValue(
                    Resource.error(
                        null,
                        "Server error,Please try after some time"
                    )
                )
            }
        }


    }


}
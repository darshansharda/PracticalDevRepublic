package com.devrepublic.practical.model

import java.io.Serializable

data class ArticlesModel(
    val author: String = "",
    val title: String = "",
    val description: String = "",
    val url: String = "",
    val urlToImage: String = "",
    val publishedAt: String = "",
    val content: String = "",
    val source: SourceModel
) : Serializable
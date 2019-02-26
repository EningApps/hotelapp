package com.eningapps.hotelisto.data.entities.network

data class NewsResponse(
    var username: String? = null,
    var news: List<ResponseNews>
)

data class ResponseNews(
    val article_id: Int? = null,
    val date_added: String? = null,
    val hobbies: List<String>? = null,
    val image_link: String? = null,
    val link: String = "www.google.com",
    val name: String? = null,
    val specializtion: String? = null,
    val subtext: String? = null,
    val theme: String? = null
)
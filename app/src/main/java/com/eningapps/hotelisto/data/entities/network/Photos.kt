package com.eningapps.hotelisto.data.entities.network


data class Photos(
    val page: Int? = null,
    val pages: Int? = null,
    val perpage: Int? = null,
    val total: Int? = null,
    val photo: List<Photo>? = null
)
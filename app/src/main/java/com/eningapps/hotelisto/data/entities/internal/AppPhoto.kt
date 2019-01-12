package com.eningapps.hotelisto.data.entities.internal

import com.eningapps.hotelisto.data.entities.network.Photo

data class AppPhoto(
    val url: String
) {

    companion object {
        public fun fromFlickrPhoto(flickrPhoto: Photo): AppPhoto {
            return AppPhoto("https://farm${flickrPhoto.farm}.staticflickr.com/${flickrPhoto.server}/${flickrPhoto.id}_${flickrPhoto.secret}_m.jpg")
        }
    }


}
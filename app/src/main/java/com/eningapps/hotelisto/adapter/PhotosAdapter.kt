package com.eningapps.hotelisto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.view.PhotoViewHolder

class PhotosAdapter(
    val context: Context
) : RecyclerView.Adapter<PhotoViewHolder>() {

    private val items: ArrayList<String> = ArrayList()

    fun updatePhotos(urls: List<String>) {
        items.clear()
        urls.forEach { items.add(it) }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        return PhotoViewHolder(
            LayoutInflater.from(context).inflate(R.layout.photo_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.loadPhoto(items[position])
    }
}

package com.eningapps.hotelisto.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eningapps.hotelisto.R
import com.eningapps.hotelisto.data.entities.internal.News
import com.eningapps.hotelisto.view.NewsViewHolder

class NewsAdapter(
    private val context: Context,
    private val newsClickListener: NewsClickListener
) : RecyclerView.Adapter<NewsViewHolder>() {

    interface NewsClickListener {

        fun onNewsClicked(newsUrl: String)
    }

    private val newsItems: ArrayList<News> = ArrayList()

    fun updateNews(news: List<News>) {
        newsItems.clear()
        news.forEach { newsItems.add(it) }
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return newsItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(
            LayoutInflater.from(context).inflate(R.layout.news_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsItems[position]
        holder.loadPhoto(item.imageUrl)
        holder.titleText.text = item.title
        holder.newsText.text = item.content
        holder.moreBtn.setOnClickListener {
            newsClickListener.onNewsClicked(item.link)
        }
    }
}

package com.coderefer.newsboard

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item.view.*

/**
 * Created by vamsitallapudi on 16/01/18.
 */
class ListRecyclerAdapter(private val news: ArrayList<News>): RecyclerView.Adapter<ListRecyclerAdapter.NewsHolder>() {


    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ListRecyclerAdapter.NewsHolder, position: Int) {
        val itemNews = news[position]
        holder.bindNews(itemNews)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerAdapter.NewsHolder{
        val inflatedView = parent.inflate(R.layout.news_item)
        return NewsHolder(inflatedView)
    }


    class NewsHolder(v:View) : RecyclerView.ViewHolder(v) , View.OnClickListener {

        private var view : View = v
        private var news : News? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            Log.d("RecyclerView", "CLICK!")

//            val context = itemView.context
//            val showPhotoIntent = Intent(context, PhotoActivity::class.java)
//            showPhotoIntent.putExtra(PHOTO_KEY, photo)
//            context.startActivity(showPhotoIntent)
        }

        fun bindNews(news: News) {
            this.news = news
            Picasso.with(view.context).load(news.news_image_url).into(view.iv_cover)
            view.tv_heading.text = news.news_title
            view.tv_source.text = news.news_source
        }
    }
}
package com.coderefer.newsboard

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.coderefer.newsboard.databinding.NewsItemBinding
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
//        testing recycler adapter
        if (position == news.size / 2 /* calculate middle element position */) {
            holder.setIsInTheMiddle(true)
        } else {
            holder.setIsInTheMiddle(false)
        }
        if (position == news.size -1 /* calculate middle element position */) {
            holder.setIsAtEnd(true)
        } else {
            holder.setIsAtEnd(false)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListRecyclerAdapter.NewsHolder{
        val inflatedView = parent.inflate(R.layout.news_item)
        return NewsHolder(inflatedView)
    }


    class NewsHolder(v:View) : RecyclerView.ViewHolder(v) , View.OnClickListener {

        private var view : View = v
        private var news : News? = null
        private var mBinding:NewsItemBinding? = null

        // We'll use this field to showcase matching the holder from the test.
        private var mIsInTheMiddle = false
        private var mIsAtEnd = false

        init {
            v.setOnClickListener {this}
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

        companion object {
            //5
            private val PHOTO_KEY = "PHOTO"
        }

        fun getIsInTheMiddle(): Boolean {
            return mIsInTheMiddle
        }

        fun setIsInTheMiddle(isInTheMiddle: Boolean) {
            mIsInTheMiddle = isInTheMiddle
        }
        fun getIsAtEnd(): Boolean {
            return mIsAtEnd
        }

        fun setIsAtEnd(isAtEnd: Boolean) {
            mIsInTheMiddle = isAtEnd
        }
    }
}
package com.coderefer.newsboard.ui.newslist

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.coderefer.newsboard.R
import com.coderefer.newsboard.databinding.ActivityMainBinding
import com.coderefer.newsboard.ui.newslist.model.News
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject
import java.io.InputStream

private const val TAG : String = "MainActivity"

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private lateinit var linearLayoutManager:LinearLayoutManager
    private lateinit var mAdapter: ListRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        linearLayoutManager = LinearLayoutManager(this)
        val jsonString:String = readJsonFromKotlinFile()
        val newsList : ArrayList<News> = parseJsonStringToNewsList(jsonString)


//        can also be declared as kotlin by default supports data binding
//        recyclerView.layoutManager = linearLayoutManager

//        using android's data binding library here
        mBinding!!.recyclerView.layoutManager = linearLayoutManager
        mAdapter = ListRecyclerAdapter(newsList)
        recyclerView.adapter = mAdapter
    }

    private fun parseJsonStringToNewsList(jsonString: String): ArrayList<News> {
        val newsList :ArrayList<News> = ArrayList<News>(0)
        val newsArray = JSONArray(jsonString)
        var i = 0
        var numIterations = newsArray.length()
        while(i < numIterations){
            val newsObject:JSONObject = newsArray.getJSONObject(i)
            val news = News()
            news.news_title = newsObject.getString("news_title")
            news.news_image_url = newsObject.getString("news_image_url")
            news.news_source = newsObject.getString("news_source")
            news.news_detail = newsObject.getString("news_detail")
            news.news_url = newsObject.getString("news_url")
            news.id = newsObject.getInt("id")
            newsList.add(news)
            i++
        }
        return newsList
    }

    private fun readJsonFromKotlinFile() :String{
        var inputString = ""
        try {
            val inputStream:InputStream = assets.open("news_data_file.json")
            inputString = inputStream.bufferedReader().use{it.readText()}
            Log.d(TAG,inputString)
        } catch (e:Exception){
            Log.d(TAG, e.toString())
        }
        return inputString
    }

}

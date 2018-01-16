package com.coderefer.newsboard

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coderefer.newsboard.databinding.ActivityMainBinding
import java.io.InputStream
class MainActivity : AppCompatActivity() {

    var mBinding: ActivityMainBinding? = null
    private val TAG : String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        readJsonFromKotlinFile()

    }

    private fun readJsonFromKotlinFile() {
        try {
            val inputStream:InputStream = assets.open("news_data_file.json")
            val inputString = inputStream.bufferedReader().use{it.readText()}
            Log.d(TAG,inputString)
        } catch (e:Exception){
            Log.d(TAG, e.toString())
        }
    }

}

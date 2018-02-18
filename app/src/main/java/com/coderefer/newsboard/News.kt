package com.coderefer.newsboard

/**
 * Created by vamsitallapudi on 16/01/18.
 */

import java.util.Date

class News {

    /**
     * id : 1
     * news_title : Hello Vamsi, This is your First News Title!
     * news_detail : Hey Vamsi, this is our first News Detail. So exciting it is, learning python, sql and writing First news App backend in Django. Its thrilling and lets continue our best effort!
     * news_image_url : http://quoteshunter.com/wp-content/uploads/2016/02/Never-Give-Up-Quotes-6.jpg
     * news_url : http://coderefer.com/
     * pub_date : 2017-07-18T18:31:50Z
     */

    var id: Int = 0
    var news_title: String? = null
    var news_detail: String? = null
    var news_image_url: String? = null
    var news_url: String? = null
    var news_source: String? = null
    var pub_date: Date? = null
}

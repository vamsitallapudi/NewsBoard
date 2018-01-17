package com.coderefer.newsboard;

/**
 * Created by vamsitallapudi on 16/01/18.
 */

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class News implements Parcelable {

    /**
     * id : 1
     * news_title : Hello Vamsi, This is your First News Title!
     * news_detail : Hey Vamsi, this is our first News Detail. So exciting it is, learning python, sql and writing First news App backend in Django. Its thrilling and lets continue our best effort!
     * news_image_url : http://quoteshunter.com/wp-content/uploads/2016/02/Never-Give-Up-Quotes-6.jpg
     * news_url : http://coderefer.com/
     * pub_date : 2017-07-18T18:31:50Z
     */

    private int id;
    private String news_title;
    private String news_detail;
    private String news_image_url;
    private String news_url;
    private String news_source;
    private Date pub_date;


    protected News(Parcel in) {
        id = in.readInt();
        news_title = in.readString();
        news_detail = in.readString();
        news_image_url = in.readString();
        news_url = in.readString();
    }

    public News(){

    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_detail() {
        return news_detail;
    }

    public void setNews_detail(String news_detail) {
        this.news_detail = news_detail;
    }

    public String getNews_image_url() {
        return news_image_url;
    }

    public void setNews_image_url(String news_image_url) {
        this.news_image_url = news_image_url;
    }


    public String getNews_source() {
        return news_source;
    }

    public void setNews_source(String news_source) {
        this.news_source = news_source;
    }

    public String getNews_url() {
        return news_url;
    }

    public void setNews_url(String news_url) {
        this.news_url = news_url;
    }

    public Date getPub_date() {
        return pub_date;
    }

    public void setPub_date(Date pub_date) {
        this.pub_date = pub_date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(news_title);
        dest.writeString(news_detail);
        dest.writeString(news_image_url);
        dest.writeString(news_source);
        dest.writeString(news_url);
    }
}

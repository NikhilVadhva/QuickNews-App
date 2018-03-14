package com.example.sambal.quicknews.Interface;

import com.example.sambal.quicknews.Common.Common;
import com.example.sambal.quicknews.Model.News;
import com.example.sambal.quicknews.Model.WebSite;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Sambal on 1/5/2018.
 */

public interface NewsService {

    @GET("v2/sources?language=en&apiKey="+ Common.API_KEY)
    Call<WebSite> getSources();

    @GET
    Call<News> getNewestArticle(@Url String url);


}

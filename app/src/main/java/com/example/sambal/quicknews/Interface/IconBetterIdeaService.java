package com.example.sambal.quicknews.Interface;

import com.example.sambal.quicknews.Model.IconBetterIdea;

import retrofit2.http.GET;
import retrofit2.http.Url;
import retrofit2.Call;

/**
 * Created by Sambal on 1/6/2018.
 */

public interface IconBetterIdeaService {

    @GET
    Call<IconBetterIdea> getIconUrl(@Url String url);
}

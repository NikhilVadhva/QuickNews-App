package com.example.sambal.quicknews.Common;

import com.example.sambal.quicknews.Interface.IconBetterIdeaService;
import com.example.sambal.quicknews.Interface.NewsService;
import com.example.sambal.quicknews.Remote.IconBetterIdeaClient;
import com.example.sambal.quicknews.Remote.RetrofitClient;

/**
 * Created by Sambal on 1/5/2018.
 */

public class Common {
    private static final String BASE_URL = "https://newsapi.org/";

    public static final String API_KEY = "2fe6e75684b6454ca552cbdd81663317";

    public static NewsService getNewsService()
    {
        return RetrofitClient.getClient(BASE_URL).create(NewsService.class);
    }

    public static IconBetterIdeaService getIconService()
    {
        return IconBetterIdeaClient.getClient(BASE_URL).create(IconBetterIdeaService.class);
    }

    // https://newsapi.org/v1/articles?source=the-next-web&sortBy=latest&apiKey=a7072d9c2ad9495a8dd5cb58a7fd30df
    public static String getAPIURL(String source, String sort_By, String apiKEY)
    {
        StringBuilder apiUrl = new StringBuilder("https://newsapi.org/v1/articles?source=");
        return apiUrl.append(source)
                .append("&sortBy=")
                .append(sort_By)
                .append("&apiKey=")
                .append(apiKEY)
                .toString();
    }
}
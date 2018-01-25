package com.example.sambal.quicknews;

import android.provider.ContactsContract;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sambal.quicknews.Adapter.ListSourceAdapter;
import com.example.sambal.quicknews.Common.Common;
import com.example.sambal.quicknews.Interface.NewsService;
import com.example.sambal.quicknews.Model.WebSite;
import com.google.gson.Gson;

import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mService;
    ListSourceAdapter adapter;
    SpotsDialog dialog;
    SwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init Cache
        Paper.init(this);

        swipeRefreshLayout = findViewById(R.id.swipRefreshLayout);
        swipeRefreshLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadWebsiteSource(true);
            }
        });

        //Init Service
        mService = Common.getNewsService();

        //Init view
        listWebsite = findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listWebsite.setLayoutManager(layoutManager);

        dialog = new SpotsDialog(this);


        loadWebsiteSource(false);

    }

    private void loadWebsiteSource(boolean isRefreshed) {
        if (!isRefreshed){
            String cache = Paper.book().read("cache");
            if (cache != null && !cache.isEmpty()) //if have cache
            {
                WebSite webSite = new Gson().fromJson(cache, WebSite.class); //Convert cache from Json to Object
                adapter = new ListSourceAdapter(getBaseContext(), webSite);
                adapter.notifyDataSetChanged();
                listWebsite.setAdapter(adapter);
            }
            else //If not have cache
            {
                dialog.show();
                //fetch new data
                mService.getSources().enqueue(new Callback<WebSite>() {
                    @Override
                    public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                        adapter = new ListSourceAdapter(getBaseContext(), response.body());
                        adapter.notifyDataSetChanged();
                        listWebsite.setAdapter(adapter);

                        //save to cache
                        Paper.book().write("cache", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<WebSite> call, Throwable t) {


                    }
                });
            }
        }
        else //If from Swipe to Refresh
        {
            dialog.show();
            //fetch new data
            mService.getSources().enqueue(new Callback<WebSite>() {
                @Override
                public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                    adapter = new ListSourceAdapter(getBaseContext(), response.body());
                    adapter.notifyDataSetChanged();
                    listWebsite.setAdapter(adapter);

                    //save to cache
                    Paper.book().write("cache", new Gson().toJson(response.body()));

                    //dismiss refresh progressing
                    swipeRefreshLayout.setRefreshing(false);

                }

                @Override
                public void onFailure(Call<WebSite> call, Throwable t) {


                }
            });
        }
    }
}
package com.example.azatkariuly.bainews.api;

import com.example.azatkariuly.bainews.models.News;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<News> getNews(
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );

    @GET("everything")
    Call<News> getNewsSearch(
            @Query("q") String keyword,
            @Query("language") String language,
            @Query("sortBy") String sortBy,
            @Query("apiKey") String apiKey
    );

    @GET("top-headlines")
    Call<News> getSource(
            @Query("country") String country,
            @Query("sources") String source,
            @Query("apiKey") String apiKey
    );

    @GET("sources")
    Call<News> getSourceAll(
            @Query("language") String language,
            @Query("country") String country,
            @Query("apiKey") String apiKey
    );
}

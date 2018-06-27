package com.example.mustafamotiwala.tindergiphy.Network;

import com.example.mustafamotiwala.tindergiphy.Model.TinderGifFeed;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @GET("/v1/gifs/trending")
    Single<TinderGifFeed> getFirstPageTrendingGifs(@Query("api_key") String api_key);

    @GET("/v1/gifs/trending")
    Single<TinderGifFeed> getNextPageTrendingGifs(@Query("api_key") String api_key, @Query("offset") int offetValue);
}

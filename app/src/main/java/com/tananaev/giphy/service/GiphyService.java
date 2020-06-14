package com.tananaev.giphy.service;

import com.tananaev.giphy.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyService {
    @GET("/v1/gifs/trending")
    Call<Response> trending(@Query("offset") int offset, @Query("limit") int limit);

    @GET("/v1/gifs/search")
    Call<Response> search(@Query("offset") int offset, @Query("limit") int limit,  @Query("q") String query);
}

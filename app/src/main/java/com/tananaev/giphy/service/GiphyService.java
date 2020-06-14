package com.tananaev.giphy.service;

import com.tananaev.giphy.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyService {
    @GET("/v1/gifs/trending")
    Call<Response> trending(@Query("offset") int offset, @Query("limit") int limit);
}

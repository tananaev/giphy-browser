package com.tananaev.giphy.repo;

import androidx.annotation.NonNull;
import androidx.paging.PositionalDataSource;

import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.model.Response;
import com.tananaev.giphy.service.GiphyService;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;

public class NetworkDataSource extends PositionalDataSource<Gif> {

    private GiphyService service;

    public NetworkDataSource(GiphyService service) {
        this.service = service;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams params, @NonNull LoadInitialCallback<Gif> callback) {
        service.trending(params.requestedStartPosition, params.requestedLoadSize).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response data = response.body();
                    callback.onResult(data.data, data.pagination.offset, data.pagination.total_count);
                } else {
                    onFailure(call, new RuntimeException("API failed"));
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                // TODO handle errors
            }
        });
    }

    @Override
    public void loadRange(@NonNull LoadRangeParams params, @NonNull LoadRangeCallback<Gif> callback) {
        service.trending(params.startPosition, params.loadSize).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if (response.isSuccessful()) {
                    Response data = response.body();
                    callback.onResult(data.data);
                } else {
                    onFailure(call, new RuntimeException("API failed"));
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                // TODO handle errors
            }
        });
    }
}

package com.tananaev.giphy.repo;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.service.GiphyService;

public class NetworkDataSourceFactory extends DataSource.Factory<Integer, Gif> {

    private GiphyService service;
    private String query;

    public NetworkDataSourceFactory(GiphyService service, String query) {
        this.service = service;
        this.query = query;
    }

    @NonNull
    @Override
    public DataSource create() {
        return new NetworkDataSource(service, query);
    }
}

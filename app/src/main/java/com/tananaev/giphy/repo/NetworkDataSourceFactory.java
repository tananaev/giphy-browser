package com.tananaev.giphy.repo;

import androidx.annotation.NonNull;
import androidx.paging.DataSource;

import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.service.GiphyService;

import javax.inject.Inject;

public class NetworkDataSourceFactory extends DataSource.Factory<Integer, Gif> {

    private GiphyService service;

    public NetworkDataSourceFactory(GiphyService service) {
        this.service = service;
    }

    @NonNull
    @Override
    public DataSource create() {
        return new NetworkDataSource(service);
    }
}

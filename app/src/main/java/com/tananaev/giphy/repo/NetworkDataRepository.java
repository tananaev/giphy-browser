package com.tananaev.giphy.repo;

import androidx.paging.DataSource;

import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.service.GiphyService;

import javax.inject.Inject;

public class NetworkDataRepository implements DataRepository {

    private GiphyService service;

    @Inject
    public NetworkDataRepository(GiphyService service) {
        this.service = service;
    }

    @Override
    public DataSource.Factory<Integer, Gif> dataSourceFactory(String query) {
        return new NetworkDataSourceFactory(service, query);
    }
}

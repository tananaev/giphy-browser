package com.tananaev.giphy.repo;

import androidx.paging.DataSource;

import com.tananaev.giphy.model.Gif;

public interface DataRepository {

    DataSource.Factory<Integer, Gif> dataSourceFactory(String keyword);
}

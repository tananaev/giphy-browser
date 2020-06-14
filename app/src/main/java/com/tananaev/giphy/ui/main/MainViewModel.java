package com.tananaev.giphy.ui.main;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.tananaev.giphy.model.Gif;
import com.tananaev.giphy.repo.DataRepository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private static final PagedList.Config PAGING_CONFIG = new PagedList.Config.Builder()
            .setPageSize(10)
            .setPrefetchDistance(30)
            .setEnablePlaceholders(true)
            .build();

    private DataRepository repository;

    @Inject
    public MainViewModel(DataRepository repository) {
        this.repository = repository;
    }

    public LiveData<PagedList<Gif>> fetchData(String keyword) {
        return new LivePagedListBuilder<>(repository.dataSourceFactory(keyword), PAGING_CONFIG).build();
    }
}

package com.tananaev.giphy.repo;

import com.tananaev.giphy.service.GiphyService;

import javax.inject.Inject;

public class MainRepository {

    private GiphyService service;

    @Inject
    public MainRepository(GiphyService service) {
        this.service = service;
    }
}

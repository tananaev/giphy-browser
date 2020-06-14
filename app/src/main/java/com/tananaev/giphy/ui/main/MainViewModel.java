package com.tananaev.giphy.ui.main;

import androidx.lifecycle.ViewModel;

import com.tananaev.giphy.repo.MainRepository;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {

    private MainRepository repository;

    @Inject
    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }
}

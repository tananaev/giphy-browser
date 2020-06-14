package com.tananaev.giphy.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tananaev.giphy.repo.MainRepository;

import javax.inject.Inject;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private MainRepository repository;

    @Inject
    public MainViewModelFactory(MainRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(repository);
    }
}

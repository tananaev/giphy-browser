package com.tananaev.giphy.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.tananaev.giphy.repo.DataRepository;

import javax.inject.Inject;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private DataRepository repository;

    @Inject
    public MainViewModelFactory(DataRepository repository) {
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new MainViewModel(repository);
    }
}

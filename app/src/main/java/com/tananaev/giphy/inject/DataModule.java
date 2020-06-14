package com.tananaev.giphy.inject;

import com.tananaev.giphy.repo.DataRepository;
import com.tananaev.giphy.repo.NetworkDataRepository;

import dagger.Binds;
import dagger.Module;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;

@Module
@InstallIn(FragmentComponent.class)
public abstract class DataModule {

    @Binds
    public abstract DataRepository provideDataRepository(NetworkDataRepository repository);
}

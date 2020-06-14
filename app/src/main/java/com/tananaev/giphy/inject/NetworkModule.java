package com.tananaev.giphy.inject;

import com.tananaev.giphy.service.GiphyService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import retrofit2.Retrofit;

@Module
@InstallIn(FragmentComponent.class)
public abstract class NetworkModule {

    @Provides
    public static GiphyService provideGiphyService() {
        return new Retrofit.Builder()
                .baseUrl("https://api.giphy.com")
                .build()
                .create(GiphyService.class);
    }
}

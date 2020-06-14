package com.tananaev.giphy.inject;

import com.tananaev.giphy.service.AuthInterceptor;
import com.tananaev.giphy.service.GiphyService;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module
@InstallIn(FragmentComponent.class)
public abstract class NetworkModule {

    @Provides
    public static OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor())
                .build();
    }

    @Provides
    public static GiphyService provideGiphyService(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.giphy.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(GiphyService.class);
    }
}

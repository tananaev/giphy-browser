package com.tananaev.giphy;

import android.app.Application;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
}

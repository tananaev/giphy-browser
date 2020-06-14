package com.tananaev.giphy.service;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private static final String API_KEY = "FdzU6ULmoB0YkKrII9Gzs0HX6fDS4YCo";

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", API_KEY)
                .build();

        Request.Builder requestBuilder = original.newBuilder().url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}

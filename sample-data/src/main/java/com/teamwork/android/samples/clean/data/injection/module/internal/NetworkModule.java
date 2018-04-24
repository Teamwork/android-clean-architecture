package com.teamwork.android.samples.clean.data.injection.module.internal;

import com.squareup.moshi.KotlinJsonAdapterFactory;
import com.squareup.moshi.Moshi;
import com.teamwork.android.samples.clean.data.BuildConfig;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import javax.inject.Singleton;

/**
 * Module that provides singleton components for networking dependencies and API.
 */
@Module
@SuppressWarnings("WeakerAccess")
public abstract class NetworkModule {

    //region OkHttp

    @Provides
    @Singleton
    static OkHttpClient provideHttpClient() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BASIC : HttpLoggingInterceptor.Level.NONE);
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(loggingInterceptor)
                .retryOnConnectionFailure(true)
                .build();
    }

    //endregion

    //region JSON (de)serialization with Moshi

    @Provides
    @Singleton
    static Moshi provideMoshi() {
        return new Moshi.Builder()
                .add(new KotlinJsonAdapterFactory())
                .build();
    }

}
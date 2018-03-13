package com.favorites.core.generics.network;

import com.favorites.core.generics.utils.FCConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 10/03/18
 */
public class FCRetrofitManager {

    private static FCRetrofitManager instance = null;
    private final OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build();

    public synchronized static FCRetrofitManager getInstance() {
        if (instance == null) {
            instance = new FCRetrofitManager();
        }
        return instance;
    }

    public Retrofit getRetrofitFC() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FCConstants.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
        return retrofit;
    }

}

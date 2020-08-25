package com.tomash.gombosh.api.rest;

import java.time.ZonedDateTime;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tomash.gombosh.api.rest.adapter.ZonedDateTimeAdapter;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class RestClient {
    private final String apiUrl;

    public RestClient(final String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public <S> S createService(final Class<S> serviceClass) {
        final OkHttpClient okHttpClient = new CustomOkHttpClient().get();
        final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(apiUrl)
            .addCallAdapterFactory(new RetryCallAdapterFactory(3, 2000))
            .addConverterFactory(GsonConverterFactory.create(createGson()))
            .client(okHttpClient)
            .build();
        return retrofit.create(serviceClass);
    }

    private Gson createGson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter());
        return gsonBuilder.create();
    }
}

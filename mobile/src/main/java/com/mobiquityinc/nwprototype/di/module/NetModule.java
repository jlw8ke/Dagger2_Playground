package com.mobiquityinc.nwprototype.di.module;

import android.content.Context;

import com.google.gson.Gson;
import com.mobiquityinc.nwprototype.R;
import com.mobiquityinc.nwprototype.di.scope.AppScope;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.logging.HttpLoggingInterceptor;

import dagger.Module;
import dagger.Provides;
import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

@Module(includes = ApiModule.class)
public class NetModule {

    @Provides
    @AppScope
    Retrofit provideRetrofit(Context context, OkHttpClient client) {
        String baseUrl = context.getString(R.string.weather_service_url);

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    @Provides
    @AppScope
    OkHttpClient provideClient(Context context) {
        OkHttpClient client = new OkHttpClient();

        client.interceptors().add(chain -> {
            Request original = chain.request();
            HttpUrl url = original.httpUrl().newBuilder()
                    .addQueryParameter("APPID", context.getString(R.string.api_key))
                    .build();
            Request newRequest = original.newBuilder()
                    .url(url)
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(newRequest);
        });
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.interceptors().add(loggingInterceptor);

        return client;
    }
}

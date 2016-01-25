package com.mobiquityinc.nwprototype.di.module;

import com.mobiquityinc.nwprototype.di.scope.AppScope;
import com.mobiquityinc.nwprototype.rest.WeatherService;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class ApiModule {

    @Provides
    @AppScope
    WeatherService provideWeatherService(Retrofit retrofit) {
        return retrofit.create(WeatherService.class);
    }
}

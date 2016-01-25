package com.mobiquityinc.nwprototype.di.module;

import com.mobiquityinc.nwprototype.Config;
import com.mobiquityinc.nwprototype.di.scope.ActivityScope;
import com.mobiquityinc.nwprototype.rest.WeatherService;
import com.mobiquityinc.nwprototype.ui.presenter.WeatherPresenter;
import com.mobiquityinc.nwprototype.ui.presenter.WeatherPresenterImpl;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    @ActivityScope
    WeatherPresenter provideWeatherPresenter(Config config, Bus bus, WeatherService weatherService) {
        return new WeatherPresenterImpl(config, bus, weatherService);
    }

}

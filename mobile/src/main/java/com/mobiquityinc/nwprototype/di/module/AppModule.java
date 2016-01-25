package com.mobiquityinc.nwprototype.di.module;

import android.content.Context;

import com.mobiquityinc.nwprototype.Config;
import com.mobiquityinc.nwprototype.MainThreadBus;
import com.mobiquityinc.nwprototype.WeatherApplication;
import com.mobiquityinc.nwprototype.di.scope.AppScope;
import com.squareup.otto.Bus;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetModule.class})
public class AppModule {

    private final WeatherApplication application;

    public AppModule(WeatherApplication application) {
        this.application = application;
    }

    @Provides
    @AppScope
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    @AppScope
    Bus provideBus() {
        return new MainThreadBus();
    }

    @Provides
    @AppScope
    Config provideConfig() {
        return new Config(application);
    }
}

package com.mobiquityinc.nwprototype;

import android.app.Application;

import com.mobiquityinc.nwprototype.di.component.AppComponent;

import timber.log.Timber;

public class WeatherApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = AppComponent.Initializer.init(this);
    }

    public AppComponent getComponent() {
        return appComponent;
    }
}

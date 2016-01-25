package com.mobiquityinc.nwprototype.di.component;

import com.mobiquityinc.nwprototype.Config;
import com.mobiquityinc.nwprototype.WeatherApplication;
import com.mobiquityinc.nwprototype.di.module.AppModule;
import com.mobiquityinc.nwprototype.di.scope.AppScope;
import com.mobiquityinc.nwprototype.rest.WeatherService;
import com.squareup.otto.Bus;

import dagger.Component;

@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {

    class Initializer {
        public static AppComponent init(WeatherApplication application) {
            return DaggerAppComponent.builder()
                    .appModule(new AppModule(application))
                    .build();
        }
    }

    Bus exposeBus();
    Config exposeConfig();
    WeatherService exposeWeatherService();
}

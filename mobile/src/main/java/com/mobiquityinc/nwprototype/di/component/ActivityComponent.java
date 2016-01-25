package com.mobiquityinc.nwprototype.di.component;

import android.app.Activity;

import com.mobiquityinc.nwprototype.WeatherApplication;
import com.mobiquityinc.nwprototype.di.module.ActivityModule;
import com.mobiquityinc.nwprototype.di.scope.ActivityScope;
import com.mobiquityinc.nwprototype.ui.activity.BaseActivity;
import com.mobiquityinc.nwprototype.ui.activity.WeatherActivity;

import dagger.Component;

@ActivityScope
@Component(
        modules = ActivityModule.class,
        dependencies = AppComponent.class
)
public interface ActivityComponent {

    class Initializer {
        public static ActivityComponent init(Activity activity) {
            AppComponent appComponent = ((WeatherApplication)activity.getApplication()).getComponent();
            return DaggerActivityComponent.builder()
                    .appComponent(appComponent)
                    .build();
        }
    }
    void inject(BaseActivity activity);
    void inject(WeatherActivity activity);
}

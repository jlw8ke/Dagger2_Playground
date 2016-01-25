package com.mobiquityinc.nwprototype.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mobiquityinc.nwprototype.di.component.ActivityComponent;
import com.squareup.otto.Bus;

import javax.inject.Inject;


public abstract class BaseActivity extends AppCompatActivity {

    private ActivityComponent component;
    @Inject Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        component = ActivityComponent.Initializer.init(this);
        component.inject(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        bus.register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        bus.unregister(this);
    }

    protected ActivityComponent getComponent() {
        return component;
    }
}

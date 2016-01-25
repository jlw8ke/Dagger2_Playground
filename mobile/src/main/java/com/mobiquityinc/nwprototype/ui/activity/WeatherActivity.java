package com.mobiquityinc.nwprototype.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mobiquityinc.nwprototype.R;
import com.mobiquityinc.nwprototype.events.WeatherEvent;
import com.mobiquityinc.nwprototype.rest.model.City;
import com.mobiquityinc.nwprototype.ui.presenter.WeatherPresenter;
import com.squareup.otto.Subscribe;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static javax.measure.unit.NonSI.FAHRENHEIT;

public class WeatherActivity extends BaseActivity
{
    @Bind(R.id.btn_get_weather) Button weatherButton;
    @Bind(R.id.city_info) ViewGroup cityInfo;

    @Bind(R.id.city_name) TextView cityTest;
    @Bind(R.id.city_coordinates) TextView cityCoordinates;
    @Bind(R.id.city_temperature) TextView cityTemperature;

    @Inject WeatherPresenter weatherPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getComponent().inject(this);
    }

    @OnClick(R.id.btn_get_weather)
    void onClickGetWeather() {
        weatherPresenter.fetchWeather();
    }

    @Subscribe
    public void onWeatherDataReceived(WeatherEvent weatherEvent) {
        City city = weatherEvent.getCity();

        cityInfo.setVisibility(View.VISIBLE);
        cityTest.setText(city.getName());
        cityCoordinates.setText(city.getCoord().toString());

        String temperature = city.getMain().getTemp() + FAHRENHEIT.toString();
        cityTemperature.setText(temperature);
    }

}

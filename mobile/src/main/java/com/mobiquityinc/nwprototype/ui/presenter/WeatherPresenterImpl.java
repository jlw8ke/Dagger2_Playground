package com.mobiquityinc.nwprototype.ui.presenter;

import com.mobiquityinc.nwprototype.Config;
import com.mobiquityinc.nwprototype.events.WeatherEvent;
import com.mobiquityinc.nwprototype.rest.WeatherService;
import com.mobiquityinc.nwprototype.rest.model.City;
import com.mobiquityinc.nwprototype.util.MathUtils;
import com.squareup.otto.Bus;

import javax.measure.converter.UnitConverter;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import timber.log.Timber;

import static javax.measure.unit.NonSI.FAHRENHEIT;
import static javax.measure.unit.SI.KELVIN;

public class WeatherPresenterImpl implements WeatherPresenter {

    private Config config;
    private Bus bus;
    private WeatherService weatherService;

    public WeatherPresenterImpl(Config config, Bus bus, WeatherService weatherService) {
        this.config = config;
        this.bus = bus;
        this.weatherService = weatherService;
    }

    @Override
    public void fetchWeather() {
        String city = config.getCity();
        weatherService.getCityWeatherData(city).enqueue(new Callback<City>() {
            @Override
            public void onResponse(Response<City> response, Retrofit retrofit) {
                if(response.isSuccess()) {
                    UnitConverter toFahrenheit = KELVIN.getConverterTo(FAHRENHEIT);
                    double temperature = toFahrenheit.convert(response.body().getMain().getTemp());

                    response.body().getMain().setTemp(MathUtils.round(temperature, 2));
                    bus.post(new WeatherEvent(response.body()));
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Timber.e(t, t.getMessage());
            }
        });

    }
}

package com.mobiquityinc.nwprototype.rest;


import com.mobiquityinc.nwprototype.rest.model.City;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface WeatherService {
    @GET("weather")
    Call<City> getCityWeatherData(@Query("q") String cityName);

}

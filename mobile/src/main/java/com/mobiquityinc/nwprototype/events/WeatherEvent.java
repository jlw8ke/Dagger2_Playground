package com.mobiquityinc.nwprototype.events;

import com.mobiquityinc.nwprototype.rest.model.City;

public class WeatherEvent {

    private City city;

    public WeatherEvent(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}

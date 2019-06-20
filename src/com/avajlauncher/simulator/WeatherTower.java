package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.Coordinates;
import com.avajlauncher.weather.WeatherProvider;

public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}

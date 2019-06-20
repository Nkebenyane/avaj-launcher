package com.avajlauncher.weather;

import com.avajlauncher.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {


    private WeatherProvider weatherProvider;

    String[] weather;

    WeatherProvider() {
        weather = new String[4];

        weather[0] = "SUN";
        weather[1] = "RAIN";
        weather[2] = "FOG";
        weather[3] = "SNOW";
    }

    public static WeatherProvider getProvider() {
        WeatherProvider ProviderObj = new WeatherProvider();
        return ProviderObj;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        Random rand = new Random();
        int i;
        i = rand.nextInt(4);
        return weather[i];
    }
}

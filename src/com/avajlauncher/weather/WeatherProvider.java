package com.avajlauncher.weather;

import com.avajlauncher.simulator.vehicles.Coordinates;

import java.util.Random;

public class WeatherProvider {


    private static WeatherProvider weatherProvider = new WeatherProvider();

    private static String[] weather;

    WeatherProvider() {
        weather = new String[4];

        weather[0] = "SUN";
        weather[1] = "RAIN";
        weather[2] = "FOG";
        weather[3] = "SNOW";
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random rand = new Random();
        int i;
        i = rand.nextInt(coordinates.getHeight());
        if (i <= coordinates.getHeight() / 2)
            i = (coordinates.getLongitude() % 4);
        else
            i = (coordinates.getLatitude() % 4);
        return weather[i];
    }
}
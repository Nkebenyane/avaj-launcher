package com.avajlauncher.simulator.vehicles;

import com.avajlauncher.simulator.Logger;
import com.avajlauncher.simulator.WeatherTower;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        //To access the parent constructor instance variable
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);


        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 4);
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 5);
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 3);
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
        }
    }

    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Logger.out("Tower says Baloon#:" + this.name + this.id + "registered to weather tower");
    }
}


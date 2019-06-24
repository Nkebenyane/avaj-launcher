package com.avajlauncher.simulator.vehicles;

import com.avajlauncher.simulator.Logger;
import com.avajlauncher.simulator.WeatherTower;

import java.util.HashMap;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        //To access the parent constructor instance variable
        super(name, coordinates);
    }

    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);

//        HashMap It stores the data in (Key, Value) pairs.

        HashMap<String, String> something = new HashMap<>();
        something.put("SUN", "Let's enjoy the good weather and take some pics.");
        something.put("RAIN", "Damn you rain! You messed up my baloon.");
        something.put("FOG", "I can't see ");
        something.put("SNOW", "It's snowing. We're gonna crash.");

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude() , coordinates.getHeight() + 4 > 100 ? 100 : coordinates.getHeight() + 4);
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 5 < 0 ? 0 : coordinates.getHeight() - 5);
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() , coordinates.getHeight() - 3 < 0 ? 0 : coordinates.getHeight() - 3);
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15 < 0 ? 0 : coordinates.getHeight() - 15);
        }

        Logger.addMessage("Baloon#" + this.name + "(" + this.id + "): " + something.get(weather));

        if (coordinates.getHeight() == 0)
        {
            Logger.addMessage("Baloon# " + this.name + this.id + "Landing");
            this.weatherTower.unregister(this);
            Logger.addMessage(("Tower says: Baloon# "+ " " + this.name + " (" + this.id + ") unregistered from weather tower"));
        }

    }

    public void registerTower(WeatherTower weatherTower) {

        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Logger.addMessage("Tower says: Baloon# " + " " + this.name + " (" + this.id + ") registered to weather tower");
        }
}
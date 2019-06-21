package com.avajlauncher.simulator.vehicles;
import com.avajlauncher.simulator.Logger;
import com.avajlauncher.simulator.WeatherTower;

import java.util.HashMap;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);

        HashMap<String, String> something = new HashMap<>();
        something.put("SUN", "It's Hot");
        something.put("RAIN", "It's raining. Better watch out for lighting.");
        something.put("FOG", "i can't see.");
        something.put("SNOW", "My rotor is going to freeze!.");

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() + 2 , coordinates.getHeight());
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude() , coordinates.getHeight());
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude() , coordinates.getHeight());
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
        }

        Logger.addMessage("Helicopter#" + this.name + "(" + this.id + "): " + something.get(weather));
        this.weatherTower.unregister(this);
//        Logger.addMessage(("Tower says: Helicopter# "+ " " + this.name + " (" + this.id + ") unregistered from weather tower"));

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Logger.addMessage("Tower says: Helicopter#: " + " " + this.name + " (" + this.id + ") registered to weather tower");
    }
}

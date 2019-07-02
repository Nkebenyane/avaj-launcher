package com.avajlauncher.simulator.vehicles;

import com.avajlauncher.simulator.Logger;
import com.avajlauncher.simulator.WeatherTower;

import java.util.HashMap;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {
        String weather = weatherTower.getWeather(this.coordinates);

        HashMap<String, String> something = new HashMap<>();
        something.put("SUN", "It's Hot");
        something.put("RAIN", "It's raining. Better watch out for lighting.");
        something.put("FOG", "OMG! winter is coming.");
        something.put("SNOW", "it's snowing. we're going to crash.");

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10 , coordinates.getHeight() + 2 > 100 ? 100 : coordinates.getHeight() + 2);
        }
        if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5 , coordinates.getHeight());
        }
        if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1 , coordinates.getHeight());
        }
        if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7 < 0 ? 0 : coordinates.getHeight() - 7);
        }
        Logger.addMessage("JetPlan#" + this.name + "(" + this.id + "): " + something.get(weather));

        if (coordinates.getHeight() == 0) {

            Logger.addMessage("JetPlane# " + this.name + " (" + this.id + ") Landing");
            this.weatherTower.unregister(this);
            Logger.addMessage(("Tower says: JetPlane# " + " " + this.name + " (" + this.id + ") unregistered from weather tower"));
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);

        Logger.addMessage("Tower says: JetPlane#: " + " " + this.name + " (" + this.id + ") registered to weather tower");
    }
}

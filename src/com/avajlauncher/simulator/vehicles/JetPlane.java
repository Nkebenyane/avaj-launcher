package com.avajlauncher.simulator.vehicles;

import com.avajlauncher.simulator.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {

    }

    public void registerTower(WeatherTower weatherTower)
    {

    }
}

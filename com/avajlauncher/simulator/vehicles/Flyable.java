package com.avajlauncher.simulator.vehicles;

import com.avajlauncher.simulator.WeatherTower;

public interface Flyable {
    void updateConditions();

    void registerTower(WeatherTower weatherTower);
}

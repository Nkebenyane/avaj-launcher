package com.avajlauncher.simulator.vehicles;

public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        Flyable object;

        if (type.equalsIgnoreCase("Baloon")) {
            object = new Baloon(name, coordinates);
            return object;
        } else if (type.equalsIgnoreCase("Helicopter")) {
            object = new Helicopter(name, coordinates);
            return object;
        } else if (type.equalsIgnoreCase("JetPlane")) {
            object = new JetPlane(name, coordinates);
            return object;
        }
        return null;
    }
}


package com.avajlauncher.simulator.vehicles;

public abstract class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        /*
          - at first I create a Coordinates object that will allow me to access the variable from the Coordinates class
         */
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        /*
        - This object will allow me to call or access the Balloon, Helicopter and JetPlane classes.
         */
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
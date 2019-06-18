package com.avajlauncher.simulator.vehicles;
import com.avajlauncher.weather.Coordinates;

public class AircraftFactory {

    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        Flyable object;

        if (type.equals("Baloon"))
        {
            object = new Baloon(name,coordinates);
            return object;
        }
        else if (type.equals("Helicopter"))
        {
            object = new Helicopter(name,coordinates);
            return object;
        }
        else if (type.equals("JetPlane"))
        {
            object = new JetPlane(name,coordinates);
            return object;
        }
        return null;
    }
}

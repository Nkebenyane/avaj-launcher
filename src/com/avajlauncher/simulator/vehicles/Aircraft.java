package com.avajlauncher.simulator.vehicles;

public class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long IdCounter = 0;

    Aircraft(String name, Coordinates coordinates)
    {
        this.coordinates = coordinates;
        this.name = name;
        this.IdCounter = nextId();
        this.id = IdCounter;
    }
    private long nextId()
    {
        return (++IdCounter);
    }
}

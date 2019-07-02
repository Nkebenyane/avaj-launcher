package com.avajlauncher.simulator.vehicles;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    private static long IdCounter = 0;

    Aircraft(String name, Coordinates coordinates) {
        /*
        This is the constructor method
        - It will initialize the class instance variables.
        - id variable it is initialized to the incremented idCounter from the nextid method
         */
        this.coordinates = coordinates;
        this.name = name;
        this.IdCounter = nextId();
        this.id = IdCounter;
    }

    private long nextId() {
        /*
        Ths function return the id of a flyable
         - So at first the IdCouter is at zero,
         - So we will increment before we return.
         */
        return (++IdCounter);
    }
}

package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.Flyable;

import java.util.ArrayList;

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }
    protected void conditionsChanged()
    {
//        for(int i = 0; i < observers.size(); i++){
//            observers.get(i).updateConditions();
//        }
        //temp is a copy of observer
        ArrayList<Flyable> temp = new ArrayList<>(this.observers);
        for(int i = 0; i < temp.size(); i++)
        {
            if (this.observers.contains(temp.get(i)))
            {
                temp.get(i).updateConditions();
            }
        }

    }
}

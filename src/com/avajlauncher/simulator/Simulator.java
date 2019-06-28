package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.AircraftFactory;
import com.avajlauncher.simulator.vehicles.Flyable;
import com.sun.javafx.binding.Logging;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    public static int count = 1;
    public static int simulation;

    public static int longitude;
    public static int latitude;
    public static int height;
    public static String type;
    public static String name;

    public static WeatherTower weatherTower;
    public static List<Flyable> flyables = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(args[0]));
            String st;
            st = br.readLine();

            if (st != null) {
                weatherTower = new WeatherTower();
                simulation = Integer.parseInt(st.split(" ")[0]);

                if (simulation <= 0) {
                    System.out.println("Invalid simulation count " + simulation);
                    System.exit(1);
                }
                while ((st = br.readLine()) != null) {
                
                    String sp[] = st.split(" ");
                    type = sp[0];
                    name = sp[1];
                    longitude = Integer.parseInt(sp[2]);
                    latitude = Integer.parseInt(sp[3]);
                    height = Integer.parseInt(sp[4]);
                 
                    Flyable flyable = AircraftFactory.newAircraft(type, name, longitude, latitude, height);
                    flyables.add(flyable);
                }
                for (Flyable flyable : flyables)
                    flyable.registerTower(weatherTower);
                while (count <= simulation) {
                    weatherTower.changeWeather();
                    count++;
                }
            }else{
                System.out.println("The file is empty dololo : nothing to read from this file");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Couldn't find the file to read. " + e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e)
        { 
            System.out.println("We need a file to read. " + e.getMessage());
        } catch(NumberFormatException e)
        {
            System.out.println("Please remove all unessesory space in your text file. " + e.getMessage());
        } finally {
            Logger.logMessage();
        }
        return;
    }
}
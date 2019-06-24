package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.AircraftFactory;
import com.avajlauncher.simulator.vehicles.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int count = 1;
    public static int simulation;

    public static int longitude;
    public static int latitude;
    public static int height;
    public static  String type;
    public static String name;

    public static WeatherTower weatherTower;
    public static List<Flyable>flyables = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        if (args.length < 1)
        {
            System.out.println("input file not found :(");
            return;
        }
//        File file = new File("scenario.txt");
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String st;

        //reading the first line
        st = br.readLine();
        try{
            if (st != null)
            {
                weatherTower = new WeatherTower();
                //convert string to integer
                simulation = Integer.parseInt(st);

                if (simulation < 0)
                {
                    System.out.println("Invalid simulation count " + simulation);
                    System.exit(1);
                }
                while ((st = br.readLine()) != null)
                {
                    String sp[] = st.split(" ");
                    type = sp[0];
                    name = sp[1];
                    longitude = Integer.parseInt(sp[2]);
                    latitude = Integer.parseInt(sp[3]);
                    height = Integer.parseInt(sp[4]);

                    Flyable flyable = AircraftFactory.newAircraft(type,name,longitude,latitude,height);
                    flyables.add(flyable);
                }
                for(Flyable flyable : flyables)
                    flyable.registerTower(weatherTower);
                while (count <= simulation)
                {
                    weatherTower.changeWeather();
                    count++;
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Couldn't find the file to read ");
        }finally {
            Logger.logMessage();
        }
        return;
    }
}

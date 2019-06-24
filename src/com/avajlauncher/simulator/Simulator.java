package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.AircraftFactory;
import com.avajlauncher.simulator.vehicles.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

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
        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        String st;

        /* reading the first line
           - By using read_liner() method the BufferReader will read through our file line by line
        */
        st = br.readLine();
        try{
            if (st != null)
            {
                weatherTower = new WeatherTower();
                //-- convert the fist line (string to integer) --
                simulation = Integer.parseInt(st);

                if (simulation < 0)
                {
                    System.out.println("Invalid simulation count " + simulation);
                    System.exit(1);
                }
                //starting from the second line to read.
                while ((st = br.readLine()) != null)
                {
                    /*
                        From the second Line BufferReader contains Strings and integers
                        - We fist need to split our line in to an array string of using split() method.
                        - Then convert index 2 - index 4 to integer. which is our coordinates.
                    */
                    String sp[] = st.split(" ");
                    type = sp[0];
                    name = sp[1];
                    longitude = Integer.parseInt(sp[2]);
                    latitude = Integer.parseInt(sp[3]);
                    height = Integer.parseInt(sp[4]);
                    /*
                       Create an object that will allow you to access the flyable class(interface).
                       Pass your variable in the newAircraft() method.
                       then add your array of flyables.
                    */
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

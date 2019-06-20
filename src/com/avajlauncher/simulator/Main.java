package com.avajlauncher.simulator;

import com.avajlauncher.simulator.vehicles.Aircraft;
import com.avajlauncher.simulator.vehicles.AircraftFactory;
import com.avajlauncher.simulator.vehicles.Baloon;
import com.avajlauncher.simulator.vehicles.Flyable;

import java.io.*;

public class Main {

    public static int count = 0;
    public static int i = 0;
    public static int longitude;

    public static int latitude;
    public static int height;


    public static PrintWriter writer;

    public static void main(String[] args) throws Exception {
        File file = new File("scenario.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        st = br.readLine();

        //convert string to integer
        i = Integer.parseInt(st);

        File simulationFile = new File("simulation.txt");
        writer = new PrintWriter(simulationFile);

        while ((st = br.readLine()) != null) {

            try {
                String sp[] = st.split(" ");
                if (sp[2] != null) {
                    longitude = Integer.parseInt(sp[2]);
                }
                if (sp[3] != null) {
                    latitude = Integer.parseInt(sp[3]);
                }
                if (sp[4] != null) {
                    height = Integer.parseInt(sp[4]);
                }

            } catch (NumberFormatException e) {
                System.out.println("The Exception Error: " + e.getMessage());
            }
        }
        while (count <= i) {
            if (i <= 0) {
                System.out.println(" number of cycles must be more than zero");
                return;
            }
            count++;
        }

        AircraftFactory test = new AircraftFactory();
        test.newAircraft("Baloon", "B1", longitude, latitude, height);

        writer.close();

        return;

    }
}

package com.avajlauncher.simulator;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.*;


public class Logger {

    public static PrintWriter writer;

    public Logger()throws Exception
    {
        File simulationFile = new File("simulation.txt");
        writer = new PrintWriter(simulationFile);
    }

    public static void out(String s)
    {
        writer.println(s);
        writer.flush();
        writer.close();
    }

}

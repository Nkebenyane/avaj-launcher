package com.avajlauncher.simulator;
import java.io.*;

public class Main {

    public static int count = 0;
    public static int i = 0;
    public static int longitude;

    public static int latitude;
    public static int height;
    public static void main(String[] args)throws Exception
    {
        File file = new File("scenario.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;

        st = br.readLine();

        //convert string to integer
        i = Integer.parseInt(st);
        System.out.println("number of cycle: " + i);

        while ((st = br.readLine()) != null) {

            try {
                String sp[] = st.split(" ");
                if (sp[2] != null) {
                    longitude = Integer.parseInt(sp[2]);
                }
                System.out.println("longitude "+longitude);
                if (sp[3] != null) {
                    latitude = Integer.parseInt(sp[3]);
                }
                System.out.println("latitude "+latitude);
                if (sp[4] != null) {
                    height = Integer.parseInt(sp[4]);
                }
                System.out.println("height "+height);
                System.out.println();
            }catch (NumberFormatException e) {
                System.out.println("The Exception Error: " + e.getMessage());
            }
        }
        while (count <= i) {
            if (i <= 0)
            {

                System.out.println(" number of cycles must be more than zero");
                return;
            }
            count++;
        }
        Logger write = new Logger();

        write.out("lol");

        return;

    }
}

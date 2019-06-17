//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static int count = 0;
    public static int i = 0;
    public static int longitude;
    public static int latitude;
    public static int height;

    public Main() {
    }

    public static void main(String[] var0) throws Exception {
        File var1 = new File("text.txt");
        BufferedReader var2 = new BufferedReader(new FileReader(var1));
        String var3 = var2.readLine();
        i = Integer.parseInt(var3);
        System.out.println("number of cycle: " + i);

        while((var3 = var2.readLine()) != null) {
            try {
                String[] var4 = var3.split(" ");
                if (var4[2] != null) {
                    longitude = Integer.parseInt(var4[2]);
                }

                System.out.println("longitude " + longitude);
                if (var4[3] != null) {
                    latitude = Integer.parseInt(var4[3]);
                }

                System.out.println("latitude " + latitude);
                if (var4[4] != null) {
                    height = Integer.parseInt(var4[4]);
                }

                System.out.println("height " + height);
                System.out.println();
            } catch (NumberFormatException var5) {
                System.out.println("The Exception Error: " + var5.getMessage());
            }
        }

        while(count <= i) {
            if (i <= 0) {
                System.out.println(" number of cycles must be more than zero");
                return;
            }

            ++count;
        }

    }
}

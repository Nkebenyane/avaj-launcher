package com.avajlauncher.weather;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    public Coordinates(int longitude, int latitude, int height){
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = height;
    }

    public int getLongitude() {
        return longitude;
    }
    public int getLatitute() {
        return latitude;
    }
    private int getHeight(){
        return height;
    }
}

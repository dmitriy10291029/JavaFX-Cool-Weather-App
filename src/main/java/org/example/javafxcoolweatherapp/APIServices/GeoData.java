package org.example.javafxcoolweatherapp.APIServices;

public class GeoData {
    private final int lat;
    private final int lon;

    public GeoData(int lat, int lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public int getLat() {
        return lat;
    }

    public int getLon() {
        return lon;
    }
}

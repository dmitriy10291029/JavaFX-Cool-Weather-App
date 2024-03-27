package org.example.javafxcoolweatherapp.DataObjects;

public class GeoDataObject {
    private final int lat;
    private final int lon;

    public GeoDataObject(int lat, int lon) {
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

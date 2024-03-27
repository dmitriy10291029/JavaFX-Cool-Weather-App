package org.example.javafxcoolweatherapp.DataObjects;

public class GeoDataObject {
    private final double lat;
    private final double lon;

    public GeoDataObject(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}

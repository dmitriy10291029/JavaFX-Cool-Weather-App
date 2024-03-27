package org.example.javafxcoolweatherapp.APIServices;

import java.util.List;

public interface RecentCityCacheable {
    List<String> getRecentCitiesList();
    boolean deleteRecentCity(final String city);
    boolean addRecentCity(final String city);
}

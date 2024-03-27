package org.example.javafxcoolweatherapp.APIServices;

public class OpenWeatherAPICallBuilder implements WeatherAPICallBuilder {
    private final String APIKey;// = "5444a50a846c6b05227cf5d443fa903c";
    static private final String WEATHER_SERVICE_URL = "http://api.openweathermap.org/data/2.5/forecast?id=524901&appid=";

    public OpenWeatherAPICallBuilder(String APIKey) {
        this.APIKey = APIKey;
    }

    @Override
    public String getAPICall(String city) {
        return null;
    }

    private GeoData getGeoDataFromService() {
        return null;
    }
}

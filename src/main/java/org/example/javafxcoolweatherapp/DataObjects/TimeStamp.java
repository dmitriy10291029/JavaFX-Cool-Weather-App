package org.example.javafxcoolweatherapp.DataObjects;

public class TimeStamp {
    private final long forecastTimeUnixUTC;
    private final double feelsLikeCelsius;
    private final double pressureHPa;
    private final double humidityPercents;

    private final String weatherDescription;
    private final double windSpeedMetersSec;
    private final long sunriseUnixTimeUTC;
    private final long sunsetUnixUTC;

    public TimeStamp(long forecastTimeUnixUTC,
                     double feelsLikeCelsius,
                     double pressureHPa,
                     double humidityPercents,
                     String weatherDescription,
                     double windSpeedMetersSec,
                     long sunriseUnixTimeUTC,
                     long sunsetUnixUTC) {

        this.forecastTimeUnixUTC = forecastTimeUnixUTC;
        this.feelsLikeCelsius = feelsLikeCelsius;
        this.pressureHPa = pressureHPa;
        this.humidityPercents = humidityPercents;
        this.weatherDescription = weatherDescription;
        this.windSpeedMetersSec = windSpeedMetersSec;
        this.sunriseUnixTimeUTC = sunriseUnixTimeUTC;
        this.sunsetUnixUTC = sunsetUnixUTC;
    }

    public long getForecastTimeUnixUTC() {
        return forecastTimeUnixUTC;
    }

    public double getFeelsLikeCelsius() {
        return feelsLikeCelsius;
    }

    public double getPressureHPa() {
        return pressureHPa;
    }

    public double getHumidityPercents() {
        return humidityPercents;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public double getWindSpeedMetersSec() {
        return windSpeedMetersSec;
    }

    public long getSunriseUnixTimeUTC() {
        return sunriseUnixTimeUTC;
    }

    public long getSunsetUnixUTC() {
        return sunsetUnixUTC;
    }

    @Override
    public String toString() {
        String divider = "; ";
        return "{" +
                forecastTimeUnixUTC + divider +
                feelsLikeCelsius + divider +
                pressureHPa + divider +
                humidityPercents + divider +
                weatherDescription + divider +
                windSpeedMetersSec + divider +
                sunriseUnixTimeUTC + divider +
                sunsetUnixUTC + "}";
    }
}

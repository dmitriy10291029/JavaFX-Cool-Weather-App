package org.example.javafxcoolweatherapp.DataObjects;

import java.util.List;

public class HourlyForecastDataObject {
    private final List<TimeStampDataObject> timeStamps;

    public HourlyForecastDataObject(List<TimeStampDataObject> timeStamps) {
        this.timeStamps = timeStamps;
    }

    public TimeStampDataObject getTimeStamp(int hour, int day) {
        int timeStampIndex = day * 24 + hour;
        if (timeStampIndex < getAmountOfTimeStamps()) {
            return timeStamps.get(timeStampIndex);
        }
        return null;
    }

    public long getFirstHourUnixUTC() {
        if (getAmountOfTimeStamps() > 0) {
            return timeStamps.get(0).getForecastTimeUnixUTC();
        }
        return -1;
    }

    public int getAmountOfTimeStamps() {
        return timeStamps.size();
    }

    public int getAmountOfDays() {
        return getAmountOfTimeStamps() / 24;
    }
}

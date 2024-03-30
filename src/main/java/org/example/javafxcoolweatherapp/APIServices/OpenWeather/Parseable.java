package org.example.javafxcoolweatherapp.APIServices.OpenWeather;

@FunctionalInterface
public interface Parseable<R> {
    R parse(String data) throws Exception;
}

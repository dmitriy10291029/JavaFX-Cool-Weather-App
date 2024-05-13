package org.example.javafxcoolweatherapp.data;

@FunctionalInterface
public interface Parseable<R> {
    R parse(String data) throws Exception;
}

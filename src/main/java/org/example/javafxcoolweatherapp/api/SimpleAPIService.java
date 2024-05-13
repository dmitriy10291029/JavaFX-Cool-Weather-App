package org.example.javafxcoolweatherapp.api;

import java.io.IOException;

public interface SimpleAPIService<DataObject, Parameter> {
    DataObject getData(Parameter parameter) throws IOException;
}

package org.example.javafxcoolweatherapp.APIServices;

public interface SimpleAPIService<DataObject, Parameter> {
    DataObject getData(Parameter parameter);
}

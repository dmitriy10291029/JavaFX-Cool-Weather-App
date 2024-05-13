package org.example.javafxcoolweatherapp.netio;

import java.io.IOException;

public interface URLManager {
    String getData(String urlAddress) throws IOException;
}

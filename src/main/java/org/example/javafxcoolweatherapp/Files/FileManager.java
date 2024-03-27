package org.example.javafxcoolweatherapp.Files;

public interface FileManager {
    boolean saveDataToFile(String fileName, String data);

    String readData(String fileName);

    boolean deleteFile(String fileName, String data);
}

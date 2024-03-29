package org.example.javafxcoolweatherapp.Files;

import java.util.List;

public interface FileManager {
    boolean saveDataToFile(String fileName, String data);

    String readData(String fileName);

    boolean deleteFile(String fileName);

    List<String> getFilesList();
}

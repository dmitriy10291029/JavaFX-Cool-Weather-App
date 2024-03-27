package org.example.javafxcoolweatherapp.Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SimpleFileManager implements FileManager {
    private static final String BASE_WORKING_DIR = "./savings/";
    private final String workingDir;

    public SimpleFileManager() {
        this(null);
    }

    public SimpleFileManager(String workingDir) {
        if (workingDir == null) {
            this.workingDir = BASE_WORKING_DIR;
        } else {
            this.workingDir = BASE_WORKING_DIR + workingDir + "/";
        }
    }

    public boolean saveDataToFile(String fileName, String data) {
        try {
            Files.writeString(getFile(fileName), data);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public String readData(String fileName) {
        try {
            return Files.readString(getFile(fileName));
        } catch (Exception e) {
            return null;
        }
    }

    public boolean deleteFile(String fileName, String data) {
        try {
            return Files.deleteIfExists(getFile(fileName));
        } catch (IOException e) {
            return false;
        }
    }

    private Path getFile(String fileName) {
        return Paths.get(workingDir + fileName);
    }
}

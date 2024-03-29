package org.example.javafxcoolweatherapp.Files;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleFileManager implements FileManager {
    private static final String BASE_WORKING_DIR = ".";
    private final Path workingDir;

    public SimpleFileManager() throws IOException {
        this(null);
    }

    public SimpleFileManager(String workingDirName) throws IOException {
        if (workingDirName == null) {
            workingDir = Paths.get(BASE_WORKING_DIR);
        } else {
            workingDir = Paths.get(BASE_WORKING_DIR, workingDirName);
        }

        if (!Files.exists(workingDir)) {
            Files.createDirectory(workingDir);
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

    public boolean deleteFile(String fileName) {
        try {
            return Files.deleteIfExists(getFile(fileName));
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<String> getFilesList() {
        try (Stream<Path> stream = Files.list(workingDir)) {
            return stream
                .map(Path::getFileName)
                .map(Path::toString)
                .collect(Collectors.toList());
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    private Path getFile(String fileName) {
        return Paths.get(workingDir.getFileName().toString(), fileName);
    }
}

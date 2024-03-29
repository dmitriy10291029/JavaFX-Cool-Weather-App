package org.example.javafxcoolweatherapp.APIServices;

import org.example.javafxcoolweatherapp.Files.FileManager;
import org.example.javafxcoolweatherapp.Files.SimpleFileManager;
import org.example.javafxcoolweatherapp.URL.SimpleURLManager;
import org.example.javafxcoolweatherapp.URL.URLManager;

import java.io.IOException;
import java.util.List;

public abstract class AbstractCacheableSimpleAPIService<DataObject>
        implements SimpleAPIService<DataObject, String> {

    protected final String APIKey;
    protected final URLManager urlManager;
    protected FileManager fileManager;
    protected boolean cacheAccess;

    public AbstractCacheableSimpleAPIService(String APIKey, String cacheDir) {
        this.APIKey = APIKey;
        urlManager = new SimpleURLManager();
        try {
            fileManager = new SimpleFileManager(cacheDir);
            cacheAccess = true;
        } catch (IOException e) {
            fileManager = null;
            cacheAccess = false;
        }
    }

    abstract protected String getResponseByURL(String parameter);

    abstract protected DataObject parseJSONResponse(String data);

    @Override
    public DataObject getData(String parameter) {
        DataObject cachedGeoData = getCachedData(parameter);
        if (cachedGeoData != null) {
            return cachedGeoData;
        } else {
            return getDataByURL(parameter);
        }
    }

    public DataObject getDataByURL(String parameter) {
        String response = getResponseByURL(parameter);
        DataObject newData = parseJSONResponse(response);
        if (newData != null) {
            if (cacheAccess) {
                fileManager.saveDataToFile(parameter, response);
            }
            return newData;
        }
        return null;
    }

    public DataObject getCachedData(String parameter) {
        if (cacheAccess && fileManager.getFilesList().contains(parameter)) {
            return parseJSONResponse(fileManager.readData(parameter));
        }
        return null;
    }

    public List<String> getRecentList() {
        return fileManager.getFilesList();
    }

    public boolean deleteRecent(String parameter) {
        return fileManager.deleteFile(parameter);
    }
}

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

    abstract protected String getResponseByURL(String parameter) throws IOException;

    abstract protected DataObject parseJSONResponse(String data) throws IOException;

    @Override
    public DataObject getData(String parameter) throws IOException {
        try { return getCachedData(parameter);

        } catch (IOException cacheEx) {
            try { return getDataByURL(parameter);

            } catch (IOException urlEx) {
                IOException e = new IOException("API Service did not get data from cache and url.", urlEx);
                e.addSuppressed(cacheEx);
                throw e;
            }
        }
    }

    public DataObject getDataByURL(String parameter) throws IOException {
        try {
            String response = getResponseByURL(parameter);
            DataObject newData;

            try { newData = parseJSONResponse(response);
            } catch (IOException e) {
                throw new IOException("Data was got, but it can not be parsed.", e);
            }

            if (cacheAccess) {
                try { fileManager.saveDataToFile(parameter, response);
                } catch (IOException ignore) { }
            }

            return newData;

        } catch (IOException ioe) {
            throw new IOException("API Service did not get data from URL Manager", ioe);
        }
    }

    public DataObject getCachedData(String parameter) throws IOException {
        if (cacheAccess && fileManager.getFilesList().contains(parameter)) {
            return parseJSONResponse(fileManager.readData(parameter));
        } else {
            throw new IOException("Can not get data from cache.");
        }
    }

    public List<String> getRecentList() {
        return fileManager.getFilesList();
    }

    public boolean deleteRecent(String parameter) {
        return fileManager.deleteFile(parameter);
    }
}

package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Shikha Rani
 */
public class PropertyUtilities {
    /**
     *
     * @param path
     * @param key
     * @return
     * @throws IOException
     */
    public String readingFromPropertyFile(String path,String key) throws IOException {
        FileInputStream fileInputStream=new FileInputStream(path);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        return properties.getProperty(key);
    }
}


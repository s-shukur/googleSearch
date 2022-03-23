package com.googleSearch.uitils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * reads the properties file configuration.properties
     */
    private static Properties properties;

    static {
        try {
            String path = "Configuration.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName) {
        return properties.getProperty(keyName);
    }

}

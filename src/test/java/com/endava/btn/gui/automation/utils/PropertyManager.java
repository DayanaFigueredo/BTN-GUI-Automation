package com.endava.btn.gui.automation.utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final String CONFIG = "config";
    private static final String AUTH = "auth";
    private static String configFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\config.properties";
    private static String authFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\auth.properties";
    private static Properties properties = new Properties();

    private static void loadProperties(String file) {
        try {
            switch (file) {
                case CONFIG:
                    properties.load(new FileInputStream(configFilePath));
                    break;
                case AUTH:
                    properties.load(new FileInputStream(authFilePath));
                    break;
            }
        } catch (IOException e) {
            System.out.println("Configuration properties file cannot be found");
        }
    }

    public static String getConfigValueByKey(String key) {
        loadProperties("config");
        return properties.getProperty(key);
    }

    public static String getAuthValueByKey(String key) {
        loadProperties("auth");
        return properties.getProperty(key);
    }
}

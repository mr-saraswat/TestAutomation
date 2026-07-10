package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        try(InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream("config.properties"))
        {
if (inputStream==null){
    throw new RuntimeException("config file not present");
}
else {
    properties.load(inputStream);
}
        } catch (IOException e) {
            throw new RuntimeException("Failed to load Config file: ConfigReader.class.getClassLoader().getResourceAsStream(\"config.properties\")",e);
        }
    }
    private ConfigReader(){
    }
    public static String getProperty(String key)
    {
        return properties.getProperty(key);
    }
}

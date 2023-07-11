package core.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public static Properties getProperties(String configFilePath){
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(configFilePath)) {
            properties.load(fileInputStream);
        }
     catch (IOException e) {
        e.printStackTrace();
    }
        return properties;
    }
}

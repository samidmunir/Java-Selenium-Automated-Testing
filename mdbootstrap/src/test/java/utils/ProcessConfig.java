package utils;

import java.io.InputStream;
import java.util.Properties;

public class ProcessConfig {
    private static final Properties configProps = new Properties();

    static {
        try (InputStream input = ProcessConfig.class.getClassLoader().getResourceAsStream("config/config.properties")) {
            if (input == null) {
                throw new RuntimeException("Could not find the config.properties file");
            }

            configProps.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties file", e);
        }
    }

    public static String getProperty(String key) {
        return configProps.getProperty(key);
    }
}
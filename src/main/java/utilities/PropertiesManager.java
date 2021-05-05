package utilities;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(
                    PropertiesManager.class.getClassLoader().getResourceAsStream("configuration.properties")
            );
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static boolean isLocalRunMode() {
        return "local".equals(properties.getProperty("runMode"));
    }

    public static String getURL() {
        if (isLocalRunMode()) {
            return properties.getProperty("localApplicationURL");
        } else {
            return properties.getProperty("remoteApplicationURL");
        }
    }
}

package nl.han.aim.oose.dea.datasource.util;

import java.io.IOException;
import java.util.Properties;

public abstract class DatabaseProperties {
    private final static String CONNECTIONSTRING = "connectionstring";
    private final static String DRIVER = "driver";
    protected Properties properties;

    public String getConnectionString() {
        return properties.getProperty(CONNECTIONSTRING);
    }

    public String getDriver() {
        return properties.getProperty(DRIVER);
    }

    public DatabaseProperties(String resourceFileName) {
        properties = new Properties();
        System.out.println("Loading '" + resourceFileName + "'");
        try {
            properties.load(getClass().getClassLoader().getResourceAsStream(resourceFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            Class.forName(properties.getProperty("driver"));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

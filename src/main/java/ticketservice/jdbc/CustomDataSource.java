package ticketservice.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

public class CustomDataSource {
    private static CustomDataSource instance;
    private final String driver;
    private final String url;
    private final String name;
    private final String password;

    private CustomDataSource(String driver, String url, String password, String name) {
        this.driver = driver;
        this.url = url;
        this.password = password;
        this.name = name;
    }

    public static CustomDataSource getInstance() {
        if (instance == null) {
            Properties properties = new Properties();
            try {
                properties.load(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream("db_connection.properties"));
                String driver = properties.getProperty("postgres.driver");
                String url = properties.getProperty("postgres.url");
                String password = properties.getProperty("postgres.password");
                String name = properties.getProperty("postgres.name");
                instance = new CustomDataSource(driver, url, password, name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return new CustomConnector().getConnection(url, name, password);
    }
}

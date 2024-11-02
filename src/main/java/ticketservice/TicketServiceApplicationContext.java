package ticketservice;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan
public class TicketServiceApplicationContext {
    @Bean
    public DataSource dataSource() {
        Properties properties = new Properties();
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        try {
            properties.load(
                    Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties"));
            pgSimpleDataSource.setUrl(properties.getProperty("postgres.url"));
            pgSimpleDataSource.setUser(properties.getProperty("postgres.name"));
            pgSimpleDataSource.setPassword(properties.getProperty("postgres.password"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pgSimpleDataSource;
    }
}

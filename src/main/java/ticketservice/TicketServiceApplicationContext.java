package ticketservice;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class TicketServiceApplicationContext {
    @Value("${postgres.url}")
    private String postgresUrl;
    @Value("${postgres.name}")
    private String postgresName;
    @Value("${postgres.password}")
    private String postgresPassword;

    @Bean
    public DataSource dataSource() {
        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setUrl(postgresUrl);
        pgSimpleDataSource.setUser(postgresName);
        pgSimpleDataSource.setPassword(postgresPassword);
        return pgSimpleDataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource());

        return transactionManager;
    }
}

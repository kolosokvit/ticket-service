package ticketservice.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
  @Bean
  @ConditionalOnProperty(name = "enableConditionalBean", havingValue = "true")
  public ThisIsMyFirstConditionalBean thisIsMyFirstConditionalBean() {
    return new ThisIsMyFirstConditionalBean();
  }
}

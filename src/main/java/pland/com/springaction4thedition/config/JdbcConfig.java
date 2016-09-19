package pland.com.springaction4thedition.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import pland.com.springaction4thedition.data.SpitterRepository;
import pland.com.springaction4thedition.data.jdbc.JdbcSpitterRepository;


@Configuration 
public class JdbcConfig {

  @Bean
  public DataSource dataSource() {
    return new EmbeddedDatabaseBuilder()
      .setType(EmbeddedDatabaseType.H2)
      .addScripts("classpath:spittr/db/jdbc/schema.sql", "classpath:spittr/db/jdbc/test-data.sql")
      .build();
  }
  
  @Bean
  public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
  
  //Option 1 JdbcSpitterRepository annotated with @Repository, which is in auto scanning scope
  //Option 2 Create a JdbcSpitterRepository here by @Bean
  
//  @Bean
//  public SpitterRepository spitterRepository(JdbcTemplate jdbcTemplate) {
//    return new JdbcSpitterRepository(jdbcTemplate);
//  }


  
  @Bean
  public PlatformTransactionManager transactionManager(DataSource dataSource) {
    return new DataSourceTransactionManager(dataSource);
  }

}

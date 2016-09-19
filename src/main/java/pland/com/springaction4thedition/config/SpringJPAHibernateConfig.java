package pland.com.springaction4thedition.config;

import java.io.IOException;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import pland.com.springaction4thedition.data.SpitterRepository;
import pland.com.springaction4thedition.data.hibernate.HibernateSpitterRepository;
import pland.com.springaction4thedition.data.jdbc.JdbcSpitterRepository;

@Configuration
@ComponentScan("pland.com.springaction4thedition.data.jpahibernate")
public class SpringJPAHibernateConfig {
	
	  

	  @Bean
	  public DataSource dataSource() {
	    EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
	    edb.setType(EmbeddedDatabaseType.H2);
	    edb.addScript("spittr/db/jpa/schema.sql");
	    edb.addScript("spittr/db/jpa/test-data.sql");
	    EmbeddedDatabase embeddedDatabase = edb.build();
	    return embeddedDatabase;
	  }
	  
	  @Bean
	  public JpaVendorAdapter jpaVendorAdapter() {
	    HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
	    adapter.setDatabase(Database.H2);
	    adapter.setShowSql(true);
	    adapter.setGenerateDdl(false);
	    adapter.setDatabasePlatform("org.hibernate.dialect.H2Dialect");
	    return adapter;
	  }

     @Bean
     public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter){
    	 LocalContainerEntityManagerFactoryBean emfb = new LocalContainerEntityManagerFactoryBean();
    	 emfb.setDataSource(dataSource);
    	 emfb.setJpaVendorAdapter(jpaVendorAdapter);
    	 emfb.setPackagesToScan("pland.com.springaction4thedition.data");
    	 return emfb;
    	 
     }
     
     
     /**
      * This will let spring know how to inject Hibernate EntityManagerFactory 
      * or EntityManager
      * Refer to 11.2.2
      * 
      */
     @Bean
     public PersistenceAnnotationBeanPostProcessor paPostProcessor() {
       return new PersistenceAnnotationBeanPostProcessor();
     }
     
	  /**
	   * This serves to catch platform specific exceptions to Spring's unified unchecked exceptions
	   * But it needs the relevant repository components annotated as @Component 
	   * Refer to 11.1.2
	   * @retdurn
	   */
     
     @Bean
     public BeanPostProcessor persistenceTranslation() {
       return new PersistenceExceptionTranslationPostProcessor();
     }
     
     
     @Configuration
     @EnableTransactionManagement
     public static class TransactionConfig implements TransactionManagementConfigurer {
       @Autowired
       private EntityManagerFactory emf;

       public PlatformTransactionManager annotationDrivenTransactionManager() {
         JpaTransactionManager transactionManager = new JpaTransactionManager();
         transactionManager.setEntityManagerFactory(emf);
         return transactionManager;
       }    
     }
	  

	
	

}

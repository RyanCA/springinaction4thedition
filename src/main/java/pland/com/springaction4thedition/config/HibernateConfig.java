package pland.com.springaction4thedition.config;

import java.io.IOException;
import java.util.Properties;

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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import pland.com.springaction4thedition.data.SpitterRepository;
import pland.com.springaction4thedition.data.hibernate.HibernateSpitterRepository;
import pland.com.springaction4thedition.data.jdbc.JdbcSpitterRepository;

@Configuration
@EnableTransactionManagement //Declaresive Transaction Management. Worked with @Transaction in Repository Component
@ComponentScan("pland.com.springaction4thedition.data.hibernate")
public class HibernateConfig {//implements TransactionManagementConfigurer{
	

	  @Autowired
	  private SessionFactory sessionFactory;
	  
	  @Bean
	  public DataSource dataSource() {
	    EmbeddedDatabaseBuilder edb = new EmbeddedDatabaseBuilder();
	    edb.setType(EmbeddedDatabaseType.H2);
	    edb.addScript("spittr/db/hibernate4/schema.sql");
	    edb.addScript("spittr/db/hibernate4/test-data.sql");
	    EmbeddedDatabase embeddedDatabase = edb.build();
	    return embeddedDatabase;
	  }
	  


	  /**
	   * The way Spring to get Hibernate SessionFactory refer to 11.1.1
	   * 
	   */
	  @Bean
	  public SessionFactory sessionFactoryBean() {
	    try {
	    	  /**
	    	   * Spring orm.hibernate4.LocalSessionFactoryBean in Hibernate4 and 
	    	   * beyond, it can used to configure persistent data model with DB 
	    	   * table by either configuration file such as Spitter.hbm.xml or 
	    	   * annotation or both together
	    	   */
		      LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();//Spring Framework
		      lsfb.setDataSource(dataSource());
		      lsfb.setPackagesToScan("pland.com.springaction4thedition.data");
		      Properties props = new Properties();
		      
		      /**
		       * ORM mapping path
		       * this includes classes that are annotated with JPA’s @Entity or 
		       * @MappedSuperclass and Hibernate’s own @Entity annotation
		       */
		      props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
		      lsfb.setHibernateProperties(props);
		      lsfb.afterPropertiesSet();
		      SessionFactory object = lsfb.getObject();
		      return object;
		    } catch (IOException e) {
		      return null;
		    }
	  }
	  
//	  @Bean
//	  public SpitterRepository spitterRepository(SessionFactory sessionFactory) {
//	    return new HibernateSpitterRepository(sessionFactory);
//	  }

//	  //Implement the method of the interface
//	  public PlatformTransactionManager annotationDrivenTransactionManager() {
//	    System.out.println(sessionFactory);
//	    //Here use Spring ORM Hibernate 4 HibernateTransactionManager
//	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	    transactionManager.setSessionFactory(sessionFactory);
//	    return transactionManager;
//	  }
	  
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
	  

	
	

}

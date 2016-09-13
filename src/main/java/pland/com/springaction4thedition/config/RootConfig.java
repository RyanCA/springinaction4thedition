package pland.com.springaction4thedition.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Configuration is meta-annotated with @Component, therefore @Configuration 
 * classes are candidates for component scanning
 *
 * It will scan other Components, Configurations such as SecurityConfig.java
 */
@Configuration
@ComponentScan(basePackages={"pland.com.springaction4thedition"},
    excludeFilters={
        @Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)
    })

public class RootConfig {
	

}

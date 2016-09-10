package pland.com.springaction4thedition.config;

import java.io.IOException;

import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc //The very simplest Spring MVC configuration you can create is a class annotated with @EnableWebMvc
@ComponentScan("pland.com.springaction4thedition") 

public class WebConfig extends WebMvcConfigurerAdapter {
	
	/**
	 * You can only choose one viewer for time-being
	 * Either Jsp viewer or Tiles viewer
	 */
//###############Jsp Viewer Begin###################
	//Config a jsp viewer
//	@Bean
//	public ViewResolver viewResolver(){
//		/**
//		 * This view is typical used for jsp. See reference in table 6.1
//		 */
//		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/WEB-INF/views/");
//		resolver.setSuffix(".jsp");
//		resolver.setExposeContextBeansAsAttributes(true);
//		//If jsp using JSTL tags do display format or message on different locale, then have to configure JstlView to do this job
//		resolver.setViewClass(org.springframework.web.servlet.view.JstlView.class);
//		return resolver;
//	}
//###############Jsp Viewer End###################
	
	/*
	 * asking DispatcherServlet to forward requests for static resources to the 
	 * servlet container’s default servlet and not to try to handle them itself
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	
	/**
	 * This is to initiate message bean to retrieve messages from property file
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
	  ResourceBundleMessageSource messageSource =
	          new ResourceBundleMessageSource();
	  messageSource.setBasename("messages");//The name should be same as the name in property file (here it is messages.properties)
	  return messageSource;
	}
	
	/**
	 * What to use self-defined css files, js files and image files
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	/**
	 * You can only choose one viewer for time-being
	 * Either Jsp viewer or Tiles viewer
	 */
	//###############Tile3 Viewer Begin###################
	//Add TilesConfigurer using Tiles3
	@Bean
	public TilesConfigurer tilesConfigurer(){
		TilesConfigurer tiles = new TilesConfigurer();
		tiles.setDefinitions(new String[]{"/WEB-INF/layout/tiles.xml"});
		tiles.setCheckRefresh(true);//Enable Refresh
		return tiles;
	}	
	
	//Config a tile viewer using Tiles3
	@Bean
	public ViewResolver viewResolver(){
		/**
		 * This view is typical used for jsp. See reference in table 6.1
		 */
		TilesViewResolver resolver = new TilesViewResolver();
		return resolver;
	}
	//###############Tile3 Viewer End###################
	

	/**
	 * Config multipart request and let Spring know which component can take the multipart request
	 * MultipartResolver needs to be configured a default file location, which is defined in servlet.
	 * Refer to SpittrWebAppInitializer.customizeRegistration(Dynamic registration)
	 */
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
	  return new StandardServletMultipartResolver();
	}
}

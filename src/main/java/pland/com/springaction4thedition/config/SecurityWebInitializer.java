package pland.com.springaction4thedition.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * It is a subclass of WebApplicationInitializer.class 
 * and its class instance will be instantiated by Spring automatically
 * 
 * This class will be used to registered DelegatingFilterProxy with the web container
 * 
 * The class wis equivalent to below configuration in web.xml
	<filter>
	  <filter-name>springSecurityFilterChain</filter-name>
	  <filter-class>
	    org.springframework.web.filter.DelegatingFilterProxy
	  </filter-class>
	</filter>
	
	<filter-mapping>
	  <filter-name>springSecurityFilterChain</filter-name>
	  <url-pattern>/*</url-pattern>
	  <dispatcher>ERROR</dispatcher>
	  <dispatcher>REQUEST</dispatcher>
	</filter-mapping>
 *
 * Refer to 9.1.2
 */
public class SecurityWebInitializer 
    extends AbstractSecurityWebApplicationInitializer {

}

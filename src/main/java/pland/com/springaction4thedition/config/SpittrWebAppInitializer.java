
package pland.com.springaction4thedition.config;

import java.io.File;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


/**
 * This is the 1st config class for Spring MVC. 
 * 
 * It is a subclass of WebApplicationInitializer.class 
 * and its class instance will be instantiated by Spring automatically
 * 
 * Followings are RootConfig and WebConfig
 * 
 *
 */

//@Order(1)
public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	/**
	 * Load application context created by ContextLoaderListener
	 * The beans here are typically middle-tier and data-tier components 
	 * 
	 * The effect of this method is equivalent to below configurations in web.xml
	 * 
		<listener>
		  <listener-class>
		    org.springframework.web.context.ContextLoaderListener
		  </listener-class>
		</listener>
		
		<!-- Load all Spring XML configuration including our security.xml file -->
		<context-param>
		  <param-name>contextConfigLocation</param-name>
		  <param-value>/WEB-INF/spring/*.xml</param-value>
		</context-param>
	 */
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	/**
	 * Load application context with beans defined for DispatcherServlet's application context
	 */
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}
	
	/**
	 * You can override different methods to add other servlets, filters and listeners
	 * Refer to chatper 7.1 of Spring in Action 4th Edition
	 * such as:
	 * 
	 * 	
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException{
    	javax.servlet.ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
	    myServlet.addMapping("/custom/**");
	    
	    javax.servlet.FilterRegistration.Dynamic filter = servletContext.addFilter("myFilter", MyFilter.class);
	    filter.addMappingForUrlPatterns(null, false, "/custom/**");
	}
		
	 */
	
	/**
	 * Config the register servlet to handle multipart request
	 * Refer to 7.2 of Spring in Action 4th Edition for multipart form data
	 * 
	 */
	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		File[] roots = File.listRoots();
		File file = new File(roots[0].getAbsolutePath()+File.separator
				+"xxx_tmp"+File.separator
				+"spittr"+File.separator
				+"uploads"+File.separator);
		System.out.println("file.getAbsolutePath()="+file.getAbsolutePath());
		System.out.println("file.exists()="+file.exists());
		file.mkdirs();
		System.out.println("mkdirs() in customizeRegistration() No Exception");
		
	    registration.setMultipartConfig(
	        new MultipartConfigElement(file.getAbsolutePath(),//"/tmp/spittr/uploads" this path (From Spring in Action 4th Edition) will be associated with Tomcat container, hard to predict exact path
	    		  2097152, //Max file size 2MB
	    		  4194304, //Max request size 4MB
	    		  0));//File size threshold
	}
	

	




	
}

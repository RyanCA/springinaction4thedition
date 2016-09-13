package pland.com.springaction4thedition.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;


/**
 * Spring 3.2 introduced a new Java configuration option, altogether eliminating
 *  the need for XML security configuration
 *  
 * More Spring MVC specific features compared to EnableWebSecurity
 * Such as CSRF attack; Authentication
 * Refer to Spring MVC Listing 9.2 illustrate a bit on this
 *
 */

@Configuration
@EnableWebMvcSecurity
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		//Enable an in-memory store
	    auth.inMemoryAuthentication()
	        .withUser("user").password("password").roles("USER").and()
	        .withUser("admin").password("password").roles("USER", "ADMIN");
	    
	    //Authenticate against DB
	    
	    //Authenticate with LDAP
	    //Refer to 9.2.3
	    //Refer to my project J01_Recruiting\springSecurityLDAP\src\main\webapp\WEB-INF\applicationContext-security.xml
	    
	    //9.2.4 Configuring Custom user service such as non-relational database
	    
	   
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		
		//Use default Spring login page
        http.formLogin()
        
        .and()
            .logout()
            .logoutSuccessUrl("/")
            
        .and()
            .rememberMe().tokenValiditySeconds(60) //60 seconds
            
        .and()
           .authorizeRequests()
           .antMatchers("/spitter/**").authenticated()
           .antMatchers("/spitter/**").hasRole("ADMIN");
        
        //Need HTTPS to transfer text
        //If you need to put it into Heroku, then you may need to turn off SSL
//        .and()
//           .requiresChannel().antMatchers(HttpMethod.POST,"/spitter/register").requiresSecure();
    
        /**
         * Refer to 9.3.3
         * This is used to disable the CrossSiteRequestForgery. 
         * By default, starting from Spring 3.2 this function is added and enabled
         * If you use SpringForm or Thymeleaf, the CSRF token will be automatically 
         * transfered between the server and client side
         * 
         */
//       .and().csrf().disable();
	    
	   
	}

}

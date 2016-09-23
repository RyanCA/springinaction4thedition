package pland.com.springaction4thedition.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;




/**
 * Chapter 14
 * 
 * This is a Security Mechanisam beyond Spring Web;
 * Usually you can build Web with Spring Web security. However this give you 
 * one more layer of security protection in case Web Security just failed to 
 * protect you 
 *
 * securedEnabled=true allows to use @Secured annotation on methods, which is Spring Annotation
 * jsr250Enabled=true allows to use @RolesAllowed annotation on methods, which is Java Standard Annotation
 * 
 * Both are no different only different standards
 * You can use both
 * 
 * Refer to SpitterController.java for their usage
 *
 */

@Configuration
@EnableGlobalMethodSecurity(securedEnabled=true, jsr250Enabled=true) 
public class MethodSecurityConfig extends GlobalMethodSecurityConfiguration {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	         throws Exception {
	  auth
	  .inMemoryAuthentication()
      .withUser("user").password("password").roles("USER").and()
      .withUser("admin").password("password").roles("USER", "ADMIN");
	}

}

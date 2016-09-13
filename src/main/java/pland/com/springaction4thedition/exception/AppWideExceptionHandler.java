package pland.com.springaction4thedition.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * This is for App Wide Exception Handler
 * 
 *
 */

@ControllerAdvice //@ControllerAdvice is annotated by @Component, so it is auto instantiated
public class AppWideExceptionHandler {
	
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle() {
	  return "error/duplicate";//String should be configed in tiles.xml if use tile as view
	}

}

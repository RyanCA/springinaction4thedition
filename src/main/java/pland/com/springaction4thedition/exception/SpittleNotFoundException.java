package pland.com.springaction4thedition.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Refer to the SpittleController.java 
 *
 * Map this exception to HTTP 404
 */

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Spittle Not Found")
public class SpittleNotFoundException extends RuntimeException{

}

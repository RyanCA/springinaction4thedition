package pland.com.springaction4thedition.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//@Controller is a stereotype annotation, based on the @Component annotation
public class HomeController {
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String home(){
		return "home";
	}

}

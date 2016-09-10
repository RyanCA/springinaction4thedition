package pland.com.springaction4thedition.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pland.com.springaction4thedition.data.SpittleRepository;
import pland.com.springaction4thedition.exception.DuplicateSpittleException;
import pland.com.springaction4thedition.exception.SpittleNotFoundException;


@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	
	private SpittleRepository spittleRepository;
	
	@Autowired//This is Spring annotation, you can also use @Inject, which is JSE standard. Both are interchangeable in most cases
	public SpittleController(SpittleRepository spittleRepository){
		this.spittleRepository = spittleRepository;
	}
	
	/**
	 * Recent spittles
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(Model model){
		/**
		 * model is key-value pair, so you can also use java.util.
		 * Map as model here(then you need to use model.put()); or other similar object
		 */
		
		/**
		 * model.addAttribute(value) vs model.addAttribute(key, value)
		 * The former one the key will be inferred by the type of value object.
		 * If value is List<Spittle> then the key will be assigned as spittleList
		 * Refer to Listing 5.10 of Spring in Action 4th Edition
		 */
		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
		return "spittles";
	}
	
//	@RequestMapping(value="/show", method=RequestMethod.GET)
//	public String showSpittle(
//			@RequestParam("spittle_id") long spittleId,
//			Model model){
//		model.addAttribute("spittle", spittleRepository.findOne(spittleId));
//		return "spittle";
//	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String showSpittle(
			@PathVariable("spittleId") long spittleId,
			Model model){
		
		/**
		 * Exception Handling Option 1:
		 * Added to test out mapping SpittleNotFoundException to request status code. Check SpittleNotFoundException class as well
		 */
		if(spittleId==12345){
			throw new SpittleNotFoundException();
		}
		
		if(spittleId==12346){
			throw new DuplicateSpittleException();
		}
			
		model.addAttribute("spittle", spittleRepository.findOne(spittleId));
		return "spittle";
	}
	
	/**
	 * Exception Handling Option 2:
	 * Whenever DuplicatedSpittleException is thrown, this method is invoked and returns a string (that is the view to be displayed. Config in tiles as well)
	 * It will handle all DuplicateSpittleException across all methods in SpittleController.java
	 */
	@ExceptionHandler(DuplicateSpittleException.class)
	public String handleDuplicateSpittle() {
	  return "error/duplicate";
	}
	
	
	

}

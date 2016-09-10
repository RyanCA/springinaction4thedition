package pland.com.springaction4thedition.web;

import java.io.File;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import pland.com.springaction4thedition.data.Spitter;
import pland.com.springaction4thedition.data.SpitterRepository;


@Controller
@RequestMapping("/spitter")
public class SpitterController {
	
	private SpitterRepository spitterRepository;
	
	@Autowired
	public SpitterController(SpitterRepository spitterRepository){
		this.spitterRepository = spitterRepository;
	}
	
	@RequestMapping(value="register", method=RequestMethod.GET)
	public String showRegistrationForm(Model model){
		model.addAttribute("spitter", new Spitter());
		return "registerForm";
	}
	
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String processRegistrationForm(
			@RequestPart("profilePicture") MultipartFile profilePicture, /* Config multipart request */
			@Valid Spitter spitter, 
			Errors errors){
		
		/**
		 * this block should be executed first if want to verify the forms from client
		 */
		if(errors.hasErrors()){
			return "registerForm";
		}
		
		spitterRepository.save(spitter);
		
		
		try{
			File[] roots = File.listRoots();
			File file = new File(roots[0].getAbsolutePath()+File.separator
					+"xxx_data"+File.separator
					+"spittr"+File.separator
					+profilePicture.getOriginalFilename());
			System.out.println("file.getParentFile().getAbsolutePath()="+file.getParentFile().getAbsolutePath());
			System.out.println("file.getParentFile().exists()="+file.getParentFile().exists());
			/*
			 * mkdirs() will check if dir exists, if not then create it; even more, if  parent dir of current dir doesn't exist, it will create them recursively
			 * mkdir() won't check exists or not, won't create parent dir recursively
			 */
			boolean createDirFlag = file.getParentFile().mkdirs();
			System.out.println("file.getParentFile().mkdirs()="+file.getParentFile().mkdirs());
			
			System.out.println("profilePicture.getContentType()="+profilePicture.getContentType());
			System.out.println("profilePicture.getName()="+profilePicture.getName());
			System.out.println("profilePicture.getOriginalFilename()="+profilePicture.getOriginalFilename());
			System.out.println("profilePicture.getSize()="+profilePicture.getSize());
			System.out.println("File.isFile="+file.isFile());
			System.out.println("File.getAbsolutePath="+file.getAbsolutePath());
			System.out.println("File.getName="+file.getName());
			
		    profilePicture.transferTo(file);
		    System.out.println("file tranferTo in processRegistrationForm() No Exception");
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		//InternalResourceViewResolver can interpret this as a redirect request instead of a view name
		//InternalResourceViewResolver also interpret "forward:" prefix
		return "redirect:/spitter/"+spitter.getUsername();
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.GET)
	public String showSpitterProfile(
	      @PathVariable String username, Model model) {
	  Spitter spitter = spitterRepository.findByUsername(username);
	  model.addAttribute("spitter", spitter);//Key set default as spitter???
	  return "profile";
	}

}

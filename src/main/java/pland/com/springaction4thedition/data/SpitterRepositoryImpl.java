package pland.com.springaction4thedition.data;

import org.springframework.stereotype.Component;

//@Component("spitterRepositoryImpl")
public class SpitterRepositoryImpl implements SpitterRepository {
	
	public Spitter save(Spitter spitter){
		System.out.println("This is in SpitterRepositoryImpl");
	    return spitter;
	}
	
	public Spitter findByUsername(String username){
		return new Spitter(username, "password","firstname", "lastname" );
		
	}
	

}

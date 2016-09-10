package pland.com.springaction4thedition.data;

import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl implements SpitterRepository {
	
	public Spitter save(Spitter spitter){
	   return spitter;
	}
	
	public Spitter findByUsername(String username){
		return new Spitter(username, "password","firstname", "lastname" );
		
	}
	

}

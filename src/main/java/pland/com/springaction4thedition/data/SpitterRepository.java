package pland.com.springaction4thedition.data;

public interface SpitterRepository {
	
	public Spitter save(Spitter spitter);
	
	public Spitter findByUsername(String username);
	

}

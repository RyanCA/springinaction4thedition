package pland.com.springaction4thedition.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {

	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i< count; i++){
			spittles.add(new Spittle("Spittle "+i, new Date()));
		}
		return spittles;
	}

	public Spittle findOne(long id) {
		// TODO Auto-generated method stub
		return new Spittle("Hello", new Date());
	}
	
	

}

package pland.com.springaction4thedition.data;

import java.util.List;

public interface SpittleRepository {
	  List<Spittle> findSpittles(long max, int count);
	  Spittle findOne(long id);
	}

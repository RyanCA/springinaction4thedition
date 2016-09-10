package pland.com.springaction4thedition.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import pland.com.springaction4thedition.data.Spittle;
import pland.com.springaction4thedition.data.SpittleRepository;


import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.mockito.Mockito.when;//from mockito jar
import static org.mockito.Mockito.mock;//from mockito jar
import static org.hamcrest.Matchers.hasItems;//from hamcrest-libary jar

public class SpittleControllerTest {
	
	@Test
	public void shouldShowRecentSpittles() throws Exception{
		List<Spittle> expectedSpittles = createSpittleList(20);
		
		
		/**
		 * Use mock object to test the controller. Hence It's not necessary to implement SpittleRepositoryImpl.java in terms of test purpose
		 */

		//create a mock object of a class or an interface
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		
		//mock object return particular value when particular method is called
		when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(get("/spittles"))
		.andExpect(view().name("spittles"))
		.andExpect(model().attributeExists("spittleList"))
		.andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));

		
	}
	
	@Test
	public void testSpitle() throws Exception{
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		SpittleRepository mockRepository = mock(SpittleRepository.class);
		when(mockRepository.findOne(23456)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		/**
		 * There two type request URLs, both are correct
		 * 1. /spittles/show?spittle_id=23456
		 * 2. /spittles/23456
		 * The former one resource identified by query parameter
		 * The later one resource identified by URL path. Resource Oriented (Better)
		 * 
		 * There are two different showSpittle() in Controller, each implements one of the two functions. Refer from there!
		 */
		
//		mockMvc.perform(get("/spittles/show?spittle_id=23456")) 
//		   .andExpect(view().name("spittle"))
//		   .andExpect(model().attributeExists("spittle"))
//		   .andExpect(model().attribute("spittle", expectedSpittle));
		
		mockMvc.perform(get("/spittles/23456")) 
		   .andExpect(view().name("spittle"))
		   .andExpect(model().attributeExists("spittle"))
		   .andExpect(model().attribute("spittle", expectedSpittle));
		
	}
	
	private List<Spittle> createSpittleList(int count){
		List<Spittle> spittles = new ArrayList<Spittle>();
		for(int i = 0; i< count; i++){
			spittles.add(new Spittle("Spittle "+i, new Date()));
		}
		return spittles;
	}

}

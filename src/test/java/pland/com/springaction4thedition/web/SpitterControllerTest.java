package pland.com.springaction4thedition.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.mockito.Mockito.when;//from mockito jar
import static org.mockito.Mockito.mock;//from mockito jar
import static org.mockito.Mockito.verify;//from mockito jar
import static org.mockito.Mockito.atLeastOnce;//from mockito jar
//import static org.hamcrest.Matchers.hasItems;//from hamcrest-libary jar

import pland.com.springaction4thedition.data.Spitter;
import pland.com.springaction4thedition.data.SpitterRepository;


public class SpitterControllerTest {
	
	@Test
	public void shouldShowRegistration() throws Exception{
		
		SpitterRepository mockRepository = mock(SpitterRepository.class);
		SpitterController controller = new SpitterController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		mockMvc.perform(get("/spitter/register")).andExpect(view().name("registerForm"));
		
	}
	
	/**
	 * Following test code is not a multipart request, hence comment it out
	 */
	
//	@Test
//	public void shouldProcessRegistrationForm() throws Exception{
//		
//		SpitterRepository mockRepository = mock(SpitterRepository.class);
//		Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer");
//		Spitter saved = new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
//		when(mockRepository.save(unsaved)).thenReturn(saved);
//		
//		SpitterController controller = new SpitterController(mockRepository);
//		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//		
//		mockMvc.perform(post("/spitter/register")
//				.param("firstName", "Jack")
//				.param("lastName", "Bauer")
//				.param("username", "jbauer")
//				.param("password", "24hours"))
//				.andExpect(redirectedUrl("/spitter/jbauer"));
//		
//		//This method is to test SpitterController.processRegistrationForm(), within which the repository will invoke its own save() method
//		verify(mockRepository, atLeastOnce()).save(unsaved);
//
//	}

}

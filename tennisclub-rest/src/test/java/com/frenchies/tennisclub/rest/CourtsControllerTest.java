package com.frenchies.tennisclub.rest;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.RootWebContext;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.rest.controllers.CourtsController;
/**
 * 
 * @author Corentin DORE 473308
 *
 */
@WebAppConfiguration
@ContextConfiguration(classes = { RootWebContext.class })
public class CourtsControllerTest extends AbstractTestNGSpringContextTests {

	@Mock
	private CourtFacade courtFacade;

	@Autowired
	@InjectMocks
	private CourtsController courtsController;

	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(courtsController).setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();

	}

	@Test
	public void getCourtsTest() throws Exception {

		doReturn(Collections.unmodifiableList(this.createCourts())).when(courtFacade).getAllCourts();
	
		mockMvc.perform(get("/courts")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.[?(@.idCourt==1)].type").value("CARPET"))
				.andExpect(jsonPath("$.[?(@.idCourt==2)].type").value("GRASS"));
		}	

	@Test
	public void deleteCourt() throws Exception {

		List<CourtDTO> courts = this.createCourts();
                
		mockMvc.perform(delete("/courts/1"))
				.andExpect(status().isOk());
	}

//	}
//	
//    @Test
//	public void deleteCourtNonExisting() throws Exception {
//
//		List<CourtDTO> courts = this.createCourts();
//
//		doThrow(new RuntimeException("the court does not exist")).when(courtFacade).deleteCourt(2l);
//
//		mockMvc.perform(delete("/courts/2"))
//				.andExpect(status().isNotFound());
//
//	}
	
	@Test
	public void getValidCourtTest() throws Exception {

		List<CourtDTO> courts = this.createCourts();

		doReturn(courts.get(0)).when(courtFacade).getCourtById(1l);
		doReturn(courts.get(1)).when(courtFacade).getCourtById(2l);

		mockMvc.perform(get("/courts/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.type").value("CARPET"));

		mockMvc.perform(get("/courts/2")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.type").value("GRASS"));

	}

	@Test
	public void getInvalidCourtTest() throws Exception {
		doReturn(null).when(courtFacade).getCourtById(1l);

		mockMvc.perform(get("/courts/1")).andExpect(status().is4xxClientError());

	}

	private List<CourtDTO> createCourts() {
		CourtDTO courtOne = new CourtDTO();
		courtOne.setIdCourt(1l);
		courtOne.setLatitude(505f);
		courtOne.setLongitude(205f);
		courtOne.setStatus(Status.AVAILABLE);
		courtOne.setType(CourtType.CARPET);

		CourtDTO courtTwo = new CourtDTO();
		courtTwo.setIdCourt(2l);
		courtTwo.setLatitude(705f);
		courtTwo.setLongitude(305f);
		courtTwo.setStatus(Status.AVAILABLE);
		courtTwo.setType(CourtType.GRASS);

		return Arrays.asList(courtOne, courtTwo);
	}
}
//package com.frenchies.tennisclub.rest;
//
//import static org.mockito.Mockito.doReturn;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.frenchies.tennisclub.RootWebContext;
//import com.frenchies.tennisclub.dto.CourtDTO;
//import com.frenchies.tennisclub.enums.CourtType;
//import com.frenchies.tennisclub.enums.Status;
//import com.frenchies.tennisclub.facade.CourtFacade;
//import com.frenchies.tennisclub.rest.controllers.CourtsController;
//
//@WebAppConfiguration
//@ContextConfiguration(classes = { RootWebContext.class })
//public class CourtsControllerTest extends AbstractTestNGSpringContextTests {
//
//	@Mock
//	private CourtFacade courtFacade;
//
//	@Autowired
//	@InjectMocks
//	private CourtsController courtsController;
//
//	private MockMvc mockMvc;
//
//	@BeforeClass
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = standaloneSetup(courtsController).setMessageConverters(new MappingJackson2HttpMessageConverter())
//				.build();
//
//	}
//
//	@Test
//	public void getsCourts() throws Exception {
//
//		doReturn(Collections.unmodifiableList(this.createCourts())).when(courtFacade).getAllCourts();
//
//		mockMvc.perform(get("/courts")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(jsonPath("$.[?(@.id==1)].latitude").value(505))
//				.andExpect(jsonPath("$.[?(@.id==2)].latitude").value(705));
//
//	}
//
//	@Test
//	public void getValidCourt() throws Exception {
//
//		List<CourtDTO> courts = this.createCourts();
//
//		doReturn(courts.get(0)).when(courtFacade).getCourtById(1l);
//		doReturn(courts.get(1)).when(courtFacade).getCourtById(2l);
//
//		mockMvc.perform(get("/courts/1")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(jsonPath("$.latitude").value(505));
//
//		mockMvc.perform(get("/courts/2")).andExpect(status().isOk())
//				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//				.andExpect(jsonPath("$.latitude").value(705));
//
//	}
//
//	@Test
//	public void getInvalidCourt() throws Exception {
//		doReturn(null).when(courtFacade).getCourtById(1l);
//
//		mockMvc.perform(get("/courts/1")).andExpect(status().is4xxClientError());
//
//	}
//
//	private List<CourtDTO> createCourts() {
//		CourtDTO courtOne = new CourtDTO();
//		courtOne.setIdCourt(1l);
//		courtOne.setLatitude(505);
//		courtOne.setLongitude(205);
//		courtOne.setStatus(Status.AVAILABLE);
//		courtOne.setType(CourtType.CARPET);
//
//		CourtDTO courtTwo = new CourtDTO();
//		courtTwo.setIdCourt(2l);
//		courtTwo.setLatitude(705);
//		courtTwo.setLongitude(305);
//		courtTwo.setStatus(Status.AVAILABLE);
//		courtTwo.setType(CourtType.GRASS);
//
//		return Arrays.asList(courtOne, courtTwo);
//	}
//}


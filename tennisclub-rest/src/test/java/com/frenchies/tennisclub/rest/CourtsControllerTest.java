package com.frenchies.tennisclub.rest;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
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
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.RootWebContext;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.controllers.CourtsController;
import com.frenchies.tennisclub.exceptions.ResourceNotFoundException;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;


@WebAppConfiguration
@ContextConfiguration(classes = {RootWebContext.class})
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
       mockMvc = standaloneSetup(courtsController).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    
    }

    @Test
    public void getAllCourts() throws Exception {

        doReturn(Collections.unmodifiableList(this.createCourts())).when(courtFacade).getAllCourts();
        
        mockMvc.perform(get("/courts"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.[?(@.id==1)].latitude").value(505))
                .andExpect(jsonPath("$.[?(@.id==1)].longitude").value(205))
                .andExpect(jsonPath("$.[?(@.id==1)].status").value(Status.AVAILABLE))
                .andExpect(jsonPath("$.[?(@.id==1)].type").value(CourtType.CARPET))
                .andExpect(jsonPath("$.[?(@.id==2)].latitude").value(705))
                .andExpect(jsonPath("$.[?(@.id==2)].longitude").value(305))
                .andExpect(jsonPath("$.[?(@.id==2)].status").value(Status.AVAILABLE))
                .andExpect(jsonPath("$.[?(@.id==2)].type").value(CourtType.GRASS));

    }

    @Test
    public void getValidCourt() throws Exception {

        List<CourtDTO> courts = this.createCourts();

        doReturn(courts.get(0)).when(courtFacade).getCourtById(1l);
        doReturn(courts.get(1)).when(courtFacade).getCourtById(2l);

        mockMvc.perform(get("/courts/1"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.latitude").value(505))
                .andExpect(jsonPath("$.longitude").value(205))
                .andExpect(jsonPath("$.status").value(Status.AVAILABLE))
                .andExpect(jsonPath("$.type").value(CourtType.CARPET));

        mockMvc.perform(get("/courts/2"))
                .andExpect(status().isOk())
                .andExpect(
                        content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(jsonPath("$.latitude").value(705))
                .andExpect(jsonPath("$.longitude").value(305))
                .andExpect(jsonPath("$.status").value(Status.AVAILABLE))
                .andExpect(jsonPath("$.type").value(CourtType.GRASS));

    }

    @Test
    public void getInvalidCourt() throws Exception {
        doReturn(null).when(courtFacade).getCourtById(1l);

        mockMvc.perform(get("/courts/1"))
                .andExpect(status().is4xxClientError());

    }

    
    
    
    
    
    
    private List<CourtDTO> createCourts() {
    	CourtDTO courtOne = new CourtDTO();
        courtOne.setIdCourt(1l);
        courtOne.setLatitude(505);
        courtOne.setLongitude(205);
        courtOne.setStatus(Status.AVAILABLE);
        courtOne.setType(CourtType.CARPET);
        
        CourtDTO courtTwo = new CourtDTO();
        courtTwo.setIdCourt(2l);
        courtTwo.setLatitude(705);
        courtTwo.setLongitude(305);
        courtTwo.setStatus(Status.AVAILABLE);
        courtTwo.setType(CourtType.GRASS);
        
        return Arrays.asList(courtOne, courtTwo);
    }
}

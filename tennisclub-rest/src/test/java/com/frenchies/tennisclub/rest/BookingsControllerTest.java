package com.frenchies.tennisclub.rest;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.method.annotation.ExceptionHandlerMethodResolver;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.frenchies.tennisclub.RootWebContext;
import com.frenchies.tennisclub.controllers.BookingsController;
import com.frenchies.tennisclub.controllers.GlobalExceptionController;
import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.facade.BookingFacade;


@WebAppConfiguration
@ContextConfiguration(classes = { RootWebContext.class})
public class BookingsControllerTest  extends AbstractTestNGSpringContextTests {

	@Mock
	private BookingFacade bookingFacade;

	@Autowired
	@InjectMocks
	private BookingsController bookingsController;
        
         @Autowired
        private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;
        

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(bookingsController).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();          
    }
        
        
      
    /**
     * Registering the GlobalExceptionController if @ControllerAdvice is used
     * this can be used in SetHandlerExceptionResolvers() standaloneSetup()
     * Note that new Spring version from 4.2 has already a setControllerAdvice() method on 
     * MockMVC builders, so in that case it is only needed to pass one or more
     * @ControllerAdvice(s) configured within the application
     * 
     * @return
     */
    private ExceptionHandlerExceptionResolver createExceptionResolver() {
        ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
            protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod, Exception exception) {
                Method method = new ExceptionHandlerMethodResolver(GlobalExceptionController.class).resolveMethod(exception);
                return new ServletInvocableHandlerMethod(new GlobalExceptionController(), method);
            }
        };
        exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        exceptionResolver.afterPropertiesSet();
        return exceptionResolver;
    }

	@Test
	public void debugTest() throws Exception {
		doReturn(Collections.unmodifiableList(this.createBookings())).when(
				bookingFacade).getAllBookings();
		mockMvc.perform(get("/bookings")).andDo(print());
	}

	@Test
	public void getAllBookings() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 2);
		Date date1 = cal.getTime();
		cal.set(2017, 2, 1);
		Date date2 = cal.getTime();
		
		UserDTO jean = new UserDTO();
		UserDTO jacques = new UserDTO();
		UserDTO jean2 = new UserDTO();
		UserDTO jacques2 = new UserDTO();

		doReturn(Collections.unmodifiableList(this.createBookings())).when(
				bookingFacade).getAllBookings();

		mockMvc.perform(get("/bookings"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(
						jsonPath("$.[?(@.idBooking==10)].idCourt").value(1l))
				.andExpect(
						jsonPath("$.[?(@.idBooking==10)].dateOfBooking").value(date1))
				.andExpect(
						jsonPath("$.[?(@.idBooking==10)].hourOfBooking").value(Hour24.NINE))
				.andExpect(
						jsonPath("$.[?(@.idBooking==10)].user1").value(jean))
				.andExpect(
						jsonPath("$.[?(@.idBooking==10)].user2").value(jacques))
				.andExpect(
						jsonPath("$.[?(@.idBooking==20)].idCourt").value(2l))
				.andExpect(
						jsonPath("$.[?(@.idBooking==20)].dateOfBooking").value(date2))
				.andExpect(
						jsonPath("$.[?(@.idBooking==20)].hourOfBooking").value(Hour24.SIX))
				.andExpect(
						jsonPath("$.[?(@.idBooking==20)].user1").value(jean2))
				.andExpect(
						jsonPath("$.[?(@.idBooking==20)].user2").value(jacques2));
				
	}

	@Test
	public void getValidBooking() throws Exception {

		List<BookingDTO> bookings = this.createBookings();

		doReturn(bookings.get(0)).when(bookingFacade).getBookingById(10l);
		doReturn(bookings.get(1)).when(bookingFacade).getBookingById(20l);

		mockMvc.perform(get("/bookings/10"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.idBooking").value(10l));
		mockMvc.perform(get("/bookings/20"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.idBooking").value(20l));

	}

	@Test
	public void getInvalidBooking() throws Exception {
		doReturn(null).when(bookingFacade).getBookingById(1l);

		mockMvc.perform(get("/bookings/1")).andExpect(
				status().is4xxClientError());

	}

	@Test
	public void deleteBooking() throws Exception {

		List<BookingDTO> bookings = this.createBookings();
                
		mockMvc.perform(delete("/bookings/10"))
				.andExpect(status().isOk());

	}
        
        @Test
	public void deleteBookingNonExisting() throws Exception {

		List<BookingDTO> bookings = this.createBookings();

		doThrow(new RuntimeException("the booking does not exist")).when(bookingFacade).deleteBooking(20l);

		mockMvc.perform(delete("/bookings/20"))
				.andExpect(status().isNotFound());

	}

	@Test
	public void createBooking() throws Exception {
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 2, 1);
		Date date3 = cal.getTime();
		
		UserDTO jean = new UserDTO();
		UserDTO jacques = new UserDTO();
		
		BookingCreateDTO bookingCreateDTO = new BookingCreateDTO();
		bookingCreateDTO.setDateOfBooking(date3);
		bookingCreateDTO.setHourOfBooking(Hour24.NINETEEN);
		bookingCreateDTO.setIdCourt(1l);
		bookingCreateDTO.setUser1(jean);
		bookingCreateDTO.setUser2(jacques);

		doReturn(1l).when(bookingFacade).createBooking(any(BookingCreateDTO.class));

		String json = this.convertObjectToJsonBytes(bookingCreateDTO);

		System.out.println(json);

		mockMvc.perform(
				post("/bookings/create").contentType(MediaType.APPLICATION_JSON)
						.content(json)).andDo(print())
				.andExpect(status().isOk());
	}

	
	private List<BookingDTO> createBookings() {
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 2);
		Date date1 = cal.getTime();
		cal.set(2017, 2, 1);
		Date date2 = cal.getTime();
		
		
		BookingDTO bookingOne = new BookingDTO();
		bookingOne.setIdBooking(10l);
		bookingOne.setIdCourt(1l);
		bookingOne.setDateOfBooking(date1);
		bookingOne.setHourOfBooking(Hour24.NINE);
		UserDTO jean = new UserDTO();
		UserDTO jacques = new UserDTO();
		bookingOne.setUser1(jean);
		bookingOne.setUser2(jacques);


		BookingDTO bookingTwo = new BookingDTO();
		bookingTwo.setIdBooking(20l);
		bookingTwo.setIdCourt(2l);
		bookingTwo.setDateOfBooking(date2);
		bookingTwo.setHourOfBooking(Hour24.SIX);
		UserDTO jean2 = new UserDTO();
		UserDTO jacques2 = new UserDTO();
		bookingTwo.setUser1(jean2);
		bookingTwo.setUser2(jacques2);

		return Arrays.asList(bookingOne, bookingTwo);
	}

	private static String convertObjectToJsonBytes(Object object)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}
}
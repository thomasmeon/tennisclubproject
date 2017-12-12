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
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.facade.BookingFacade;
import org.springframework.beans.factory.BeanCreationException;

@WebAppConfiguration
@ContextConfiguration(classes = { RootWebContext.class })
public class BookingsControllerTest extends AbstractTestNGSpringContextTests {

	@Mock
	private BookingFacade bookingFacade;

	@Autowired
	@InjectMocks
	private BookingsController bookingsController;

	private Calendar calendar = Calendar.getInstance();

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = standaloneSetup(bookingsController).setMessageConverters(new MappingJackson2HttpMessageConverter())
				.build();
	}

	/**
	 * Registering the GlobalExceptionController if @ControllerAdvice is used this
	 * can be used in SetHandlerExceptionResolvers() standaloneSetup() Note that new
	 * Spring version from 4.2 has already a setControllerAdvice() method on MockMVC
	 * builders, so in that case it is only needed to pass one or
	 * more @ControllerAdvice(s) configured within the application
	 * 
	 * @return
	 */
	private ExceptionHandlerExceptionResolver createExceptionResolver() {
		ExceptionHandlerExceptionResolver exceptionResolver = new ExceptionHandlerExceptionResolver() {
			protected ServletInvocableHandlerMethod getExceptionHandlerMethod(HandlerMethod handlerMethod,
					Exception exception) {
				Method method = new ExceptionHandlerMethodResolver(GlobalExceptionController.class)
						.resolveMethod(exception);
				return new ServletInvocableHandlerMethod(new GlobalExceptionController(), method);
			}
		};
		exceptionResolver.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
		exceptionResolver.afterPropertiesSet();
		return exceptionResolver;
	}
	
	@Test
	public void debugTest() throws Exception {
		doReturn(Collections.unmodifiableList(this.createBookings())).when(bookingFacade).getAllBookings();
		mockMvc.perform(get("/bookings")).andDo(print());
	}

	@Test
	public void getBookings() throws Exception {

		doReturn(Collections.unmodifiableList(this.createBookings())).when(bookingFacade).getAllBookings();

		mockMvc.perform(get("/bookings")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.[?(@.id==10)].name").value("Raspberry PI"))
				.andExpect(jsonPath("$.[?(@.id==20)].name").value("Arduino"));

	}

	@Test
	public void getValidBooking() throws Exception {

		List<BookingDTO> bookings = this.createBookings();

		doReturn(bookings.get(0)).when(bookingFacade).getBookingById(10l);
		doReturn(bookings.get(1)).when(bookingFacade).getBookingById(12l);

		mockMvc.perform(get("/bookings/10")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.IdCourt").value("11"));
		mockMvc.perform(get("/bookings/12")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$.IdCourt").value("13"));

	}

	@Test
	public void getInvalidBooking() throws Exception {
		doReturn(null).when(bookingFacade).getBookingById(10l);

		mockMvc.perform(get("/bookings/10")).andExpect(status().is4xxClientError());

	}

	@Test
	public void deleteBooking() throws Exception {

		List<BookingDTO> bookings = this.createBookings();

		mockMvc.perform(delete("/bookings/10")).andExpect(status().isOk());

	}

	@Test
	public void deleteBookingNonExisting() throws Exception {

		List<BookingDTO> bookings = this.createBookings();

		doThrow(new RuntimeException("the booking does not exist")).when(bookingFacade).deleteBooking(20l);

		mockMvc.perform(delete("/bookings/12")).andExpect(status().isNotFound());

	}

	@Test
	public void createBooking() throws Exception {

		BookingCreateDTO bookingCreateDTO = new BookingCreateDTO();
		bookingCreateDTO.setIdCourt(22l);

		doReturn(1l).when(bookingFacade).createBooking(any(BookingCreateDTO.class));

		String json = this.convertObjectToJsonBytes(bookingCreateDTO);

		System.out.println(json);

		mockMvc.perform(post("/bookings/create").contentType(MediaType.APPLICATION_JSON).content(json)).andDo(print())
				.andExpect(status().isOk());
	}

	private List<BookingDTO> createBookings() {
		BookingDTO bookingOne = new BookingDTO();
		bookingOne.setIdBooking(10L);
		bookingOne.setIdCourt(11L);
		bookingOne.setDateOfBooking(calendar.getTime());
		bookingOne.setHourOfBooking(Hour24.EIGHT);

		BookingDTO bookingTwo = new BookingDTO();
		bookingTwo.setIdBooking(12L);
		bookingTwo.setIdCourt(13L);
		bookingTwo.setDateOfBooking(calendar.getTime());
		bookingTwo.setHourOfBooking(Hour24.NINE);

		return Arrays.asList(bookingOne, bookingTwo);
	}

	private static String convertObjectToJsonBytes(Object object) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		return mapper.writeValueAsString(object);
	}
}

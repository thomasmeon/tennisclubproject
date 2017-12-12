package com.frenchies.tennisclub;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.facade.UserFacade;
import com.frenchies.tennisclub.mvc.controllers.MyBookingsController;

/**
 * Web MVC Controller Test for administering BookingsController.
 *
 * @author Dore Corentin 473308
 */

@WebAppConfiguration
public class MyBookingsControllerTest {

	@Mock
	private BookingFacade bookingFacade;

	@Mock
	private UserFacade userFacade;

	private MockMvc mockMvc;

	private BookingDTO bookingDTO;
	
	private List<BookingDTO> listBookingDTO;

	private UserDTO uTemp;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
		MyBookingsController myBookingsController = new MyBookingsController();
		myBookingsController.setBookingFacade(bookingFacade);
		mockMvc = MockMvcBuilders.standaloneSetup(myBookingsController).build();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		bookingDTO = new BookingDTO();
		bookingDTO.setIdBooking(1l);
		bookingDTO.setIdCourt(1l);
		
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 12, 10);
		Date date = cal.getTime();
		
		bookingDTO.setDateOfBooking(date);

		uTemp = new UserDTO();
		uTemp.setId(1L);
		bookingDTO.setUser1(uTemp);
		
		listBookingDTO = new ArrayList<BookingDTO>();
		listBookingDTO.add(bookingDTO);
	}
	
	@Test
	public void listAllTest() throws Exception {
		when(bookingFacade.getBookingsByUser(uTemp)).thenReturn(listBookingDTO);
		this.mockMvc.perform(get("/mybookings/show/all/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", listBookingDTO))
				.andExpect(forwardedUrl("mybookings/show"));
	}
	
	@Test
	public void listLastWeekTest() throws Exception {
		when(bookingFacade.getAllBookingsLastWeekByUser(uTemp.getId())).thenReturn(listBookingDTO);
		this.mockMvc.perform(get("/mybookings/show/lastweek/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", listBookingDTO))
				.andExpect(forwardedUrl("mybookings/show"));
	}
	
	@Test
	public void listLastMonthTest() throws Exception {
		when(bookingFacade.getAllBookingsLastMonthByUser(uTemp.getId())).thenReturn(listBookingDTO);
		this.mockMvc.perform(get("/mybookings/show/lastmonth/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", listBookingDTO))
				.andExpect(forwardedUrl("mybookings/show"));
	}
	
	@Test
	public void listLastYearTest() throws Exception {
		when(bookingFacade.getAllBookingsLastYearByUser(uTemp.getId())).thenReturn(listBookingDTO);
		this.mockMvc.perform(get("/mybookings/show/lastyear/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", listBookingDTO))
				.andExpect(forwardedUrl("mybookings/show"));
	}

	@Test
	public void bookingTest() throws Exception {

		when(bookingFacade.getBookingById(1L)).thenReturn(bookingDTO);
		this.mockMvc.perform(get("/mybookings/booking/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", bookingDTO))
				.andExpect(forwardedUrl("mybookings/booking"));

	}


}
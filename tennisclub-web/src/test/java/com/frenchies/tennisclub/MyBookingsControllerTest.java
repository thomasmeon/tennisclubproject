package com.frenchies.tennisclub;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.facade.CourtFacade;
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
	private CourtFacade courtFacade;

	private MockMvc mockMvc;

	private BookingDTO bookingDTO;

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
		bookingDTO.setIdCourt(2l);

	}

	@Test
	public void testBooking() throws Exception {

		when(bookingFacade.getBookingById(1l)).thenReturn(bookingDTO);
		this.mockMvc.perform(get("/myBookings/booking/1").accept(MediaType.parseMediaType("text/html;charset=UTF-8")))
				.andExpect(status().isOk()).andExpect(model().attributeExists("booking"))
				.andExpect(model().attribute("booking", bookingDTO)).andExpect(forwardedUrl("myBookings/booking"));

	}
}
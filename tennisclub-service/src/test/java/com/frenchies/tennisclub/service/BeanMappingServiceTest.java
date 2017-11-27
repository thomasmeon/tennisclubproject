package com.frenchies.tennisclub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

/**
 * Tests for BeanMappingService class.
 *
 * @author Dore Corentin 473308
 */

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BeanMappingService beanMappingService;

	@Test
	public void mapping() {

		User user = new User(23);
		UserDTO userDTO = new UserDTO();

		UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
		Assert.assertTrue(mappedUserDTO.equals(userDTO));
		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
		Assert.assertTrue(mappedUser.equals(user));

		Court court = new Court();
		CourtDTO courtDTO = new CourtDTO();

		CourtDTO mappedCourtDTO = beanMappingService.mapTo(court, CourtDTO.class);
		Assert.assertTrue(mappedCourtDTO.equals(courtDTO));
		Court mappedCourt = beanMappingService.mapTo(courtDTO, Court.class);
		Assert.assertTrue(mappedCourt.equals(court));
		
		Booking booking = new Booking();
		BookingDTO bookingDTO = new BookingDTO();

		BookingDTO mappedBookingDTO = beanMappingService.mapTo(booking, BookingDTO.class);
		Assert.assertTrue(mappedBookingDTO.equals(bookingDTO));
		Booking mappedBooking = beanMappingService.mapTo(bookingDTO, Booking.class);
		Assert.assertTrue(mappedBooking.equals(booking));

	}
}


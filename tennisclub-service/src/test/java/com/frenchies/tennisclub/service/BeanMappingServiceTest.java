<<<<<<< HEAD
//package com.frenchies.tennisclub.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//import org.springframework.transaction.annotation.Transactional;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import com.frenchies.tennisclub.dto.UserDTO;
//import com.frenchies.tennisclub.entity.User;
//import com.frenchies.tennisclub.mappers.BeanMappingService;
//import com.frenchies.tennisclub.service.config.ServiceConfiguration;
//
//
//@TestExecutionListeners(TransactionalTestExecutionListener.class)
//@ContextConfiguration(classes = ServiceConfiguration.class)
//@Transactional
//public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {
//
//	@Autowired
//	private BeanMappingService beanMappingService;
//
//	@Test
//	public void mapping() {
//		User user = new User();
//		UserDTO userDTO = new UserDTO();
//		user.setName("BOB");
//		userDTO.setName("BOB");
//
//		UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
//		Assert.assertTrue(mappedUserDTO.equals(userDTO));
//		User mappedUser = beanMappingService.mapTo(userDTO, User.class);
//		Assert.assertTrue(mappedUser.equals(user));
//	}
//
//}
=======
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

	// @Autowired
	// @InjectMocks
	// private BookingServiceImpl bookingService;
	//
	// private BeanMappingService beanMappingService;
	//
	// private List<Booking> bookings = new ArrayList<Booking>();
	// private List<Court> courts = new ArrayList<Court>();
	// private List<User> users = new ArrayList<User>();
	//
	// private User user;
	// private User user2;
	// private UserDTO userDTO;
	// private UserDTO user2DTO;
	// private Date dateOfBooking;
	// private Hour24 hourOfBooking;
	//
	// @BeforeClass
	// public void setup() {
	// MockitoAnnotations.initMocks(this);
	// initBooking();
	// initCourt();
	// initUser();
	//
	// }
	//
	// public void initBooking() {
	// Booking booking = new Booking();
	// BookingDTO bookingDTO = new BookingDTO();
	// booking.setIdCourt(1l);
	// booking.setUser1(user);
	// booking.setUser2(user2);
	// booking.setDateOfBooking(dateOfBooking);
	// booking.setHourOfBooking(hourOfBooking);
	// booking.setIdBooking(11l);
	// bookingDTO.setIdCourt(1l);
	// bookingDTO.setUser1(userDTO);
	// bookingDTO.setUser2(user2DTO);
	// bookingDTO.setDateOfBooking(dateOfBooking);
	// bookingDTO.setHourOfBooking(hourOfBooking);
	// bookingDTO.setIdBooking(11l);
	//
	// }
	//
	// public void initCourt() {
	// Court court = new Court(Status.AVAILABLE, CourtType.CARPET, 234, 34);
	// ;
	// CourtDTO courtDTO = new CourtDTO();
	// court.setIdCourt(2l);
	// court.setLongitude(234);
	// court.setLatitude(34);
	// court.setStatus(Status.RESERVED);
	// court.setCourtType(CourtType.GRASS);
	// court.setIdCourt(11l);
	// courtDTO.setIdCourt(2l);
	// courtDTO.setLongitude(234);
	// courtDTO.setLatitude(34);
	// courtDTO.setStatus(Status.RESERVED);
	// courtDTO.setType(CourtType.GRASS);
	// courtDTO.setIdCourt(11l);
	//
	// }
	//
	// public void initUser() {
	// User user = new User();
	// UserDTO userDTO = new UserDTO();
	// user.setMail("example@hotmail.fr");
	// user.setName("Barney");
	// user.setSurname("Stinson");
	// user.setPasswordHash("Obiwan");
	// user.setPhone("0123456789");
	// // user.setDateOfBirth();
	// user.setAdmin(true);
	// userDTO.setMail("example@hotmail.fr");
	// userDTO.setName("Barney");
	// userDTO.setSurname("Stinson");
	// userDTO.setPasswordHash("Obiwan");
	// userDTO.setPhone("0123456789");
	// // userDTO.setDateOfBirth();
	//
	// }
	//
	// @Test
	//
	// public void mapping() {
	//
	// UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
	// Assert.assertTrue(mappedUserDTO.equals(userDTO));
	// User mappedUser = beanMappingService.mapTo(userDTO, User.class);
	// Assert.assertTrue(mappedUser.equals(user));
	// }
	//
	// // public void mapping() {
	// //
	// // CourtDTO mappedCourtDTO = beanMappingService.mapTo(court, CourtDTO.class);
	// // Assert.assertTrue(mappedCourtDTO.equals(courtDTO));
	// // Court mappedCourt = beanMappingService.mapTo(courtDTO, Court.class);
	// // Assert.assertTrue(mappedCourt.equals(court));
	// //
	// // BookingDTO mappedBookingDTO = beanMappingService.mapTo(booking,
	// // BookingDTO.class);
	// // Assert.assertTrue(mappedBookingDTO.equals(bookingDTO));
	// // Booking mappedBooking = beanMappingService.mapTo(bookingDTO,
	// Booking.class);
	// // Assert.assertTrue(mappedBooking.equals(booking));
	// //
	// // UserDTO mappedUserDTO = beanMappingService.mapTo(user, UserDTO.class);
	// // Assert.assertTrue(mappedUserDTO.equals(userDTO));
	// // User mappedUser = beanMappingService.mapTo(userDTO, User.class);
	// // Assert.assertTrue(mappedUser.equals(user));
	// // }

}
>>>>>>> d89b91c6cc50a6983ef03223426c0744253ce476

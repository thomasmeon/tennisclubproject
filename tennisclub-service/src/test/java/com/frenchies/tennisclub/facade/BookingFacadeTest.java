<<<<<<< HEAD
package com.frenchies.tennisclub.facade;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.UserService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@ContextConfiguration(classes = ServiceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingFacadeTest extends AbstractTestNGSpringContextTests {
	
//	@Mock
//	private BeanMappingService beanMappingService;
//	
//	@Mock
//	private BookingService bookingService;
//	
//	@Mock
//	private UserService userService;
//
//	@Autowired
//	@InjectMocks
=======
//package com.frenchies.tennisclub.facade;
//
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import com.frenchies.tennisclub.dto.BookingCreateDTO;
//import com.frenchies.tennisclub.dto.BookingDTO;
//import com.frenchies.tennisclub.dto.UserDTO;
//import com.frenchies.tennisclub.enums.Hour24;
//import com.frenchies.tennisclub.facade.BookingFacade;
//import com.frenchies.tennisclub.facade.UserFacade;
//import com.frenchies.tennisclub.service.config.ServiceConfiguration;
//
//@ContextConfiguration(classes = ServiceConfiguration.class)
//@TestExecutionListeners(TransactionalTestExecutionListener.class)
//@Transactional
//public class BookingFacadeTest extends AbstractTestNGSpringContextTests {
//
//	@Autowired
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//	private BookingFacade bookingFacade;
//
//	@Autowired
//	private UserFacade userFacade;
//
//	private BookingCreateDTO bookingCreateDTO;
//
//	private BookingDTO bookingDTO;
<<<<<<< HEAD
//	
//	private Booking booking; 
//
//	private UserDTO userDTO1;
//	private UserDTO userDTO2;
//	
//	private User user1;
//	private User user2;
//	
//	private Long idUser1;
//	private Long idUser2;
=======
//
//	private UserDTO userDTO1;
//	private UserDTO userDTO2;
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//
//	private Calendar cal1;
//
//	@BeforeClass
//	public void setup() {
//		MockitoAnnotations.initMocks(this);
//	}
//
<<<<<<< HEAD
=======
//	// @BeforeMethod
//	// public void userDTOCreation() {
//	//
//	// }
//
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//	@BeforeMethod
//	public void prepareTestBooking() {
//		cal1 = Calendar.getInstance();
//		cal1.set(1999, 11, 10);
//
//		userDTO1 = new UserDTO();
//		userDTO1.setDateOfBirth(cal1.getTime());
//		userDTO1.setMail("jean.françois@mail.com");
//		userDTO1.setName("François");
//		userDTO1.setSurname("jean");
//		userDTO1.setPhone("+33720362718");
<<<<<<< HEAD
//		userDTO1.setId(10L);
=======
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//
//		userDTO2 = new UserDTO();
//		userDTO2.setDateOfBirth(cal1.getTime());
//		userDTO2.setMail("paul.pierre@mail.com");
//		userDTO2.setName("Pierre");
//		userDTO2.setSurname("Paul");
//		userDTO2.setPhone("+33728962718");
<<<<<<< HEAD
//		userDTO2.setId(11L);
//		
//		user1 = new User();
//		user1.setDateOfBirth(cal1.getTime());
//		user1.setMail("jean.françois@mail.com");
//		user1.setName("François");
//		user1.setSurname("jean");
//		user1.setPhone("+33720362718");
//		user1.setId(10L);
//
//		user2 = new User();
//		user2.setDateOfBirth(cal1.getTime());
//		user2.setMail("paul.pierre@mail.com");
//		user2.setName("Pierre");
//		user2.setSurname("Paul");
//		user2.setPhone("+33728962718");
//		user2.setId(11L);
//		when(beanMappingService.mapTo(userDTO1, User.class)).thenReturn(user1);
//		when(beanMappingService.mapTo(userDTO2, User.class)).thenReturn(user2);
=======
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//
//		cal1 = Calendar.getInstance();
//		cal1.set(2017, 1, 1);
//		Date date1 = cal1.getTime();
//
<<<<<<< HEAD
////		idUser1 = userFacade.createUser(userDTO1, "blabla");
////		idUser2 = userFacade.createUser(userDTO2, "blabla2");
//		
//		verify(userService).registerUser(user1, "blabla");		
//		verify(userService).registerUser(user2, "blabla2");
=======
//		userFacade.createUser(userDTO1, "blabla");
//		userFacade.createUser(userDTO2, "blabla2");
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//
//		bookingCreateDTO = new BookingCreateDTO();
//		bookingCreateDTO.setIdCourt((long) 1);
//		bookingCreateDTO.setDateOfBooking(date1);
//		bookingCreateDTO.setHourOfBooking(Hour24.EIGHT);
//		bookingCreateDTO.setUser1(userDTO1);
//		bookingCreateDTO.setUser2(userDTO2);
<<<<<<< HEAD
//		
//		booking = new Booking();
//		booking.setIdCourt((long) 1);
//		booking.setDateOfBooking(date1);
//		booking.setHourOfBooking(Hour24.EIGHT);
//		booking.setUser1(user1);
//		booking.setUser2(user2);
//		//booking.setIdBooking(12L);
//		when(beanMappingService.mapTo(bookingCreateDTO, Booking.class)).thenReturn(booking);
//		
//		bookingDTO = new BookingDTO();
//		bookingDTO.setIdCourt((long) 1);
//		bookingDTO.setDateOfBooking(date1);
//		bookingDTO.setHourOfBooking(Hour24.EIGHT);
//		bookingDTO.setUser1(userDTO1);
//		bookingDTO.setUser2(userDTO2);
//		//bookingDTO.setIdBooking(12L);
=======
//
//		bookingDTO = new BookingDTO();
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//	}
//
//	@Test
//	public void createBookingTest() {
<<<<<<< HEAD
//		when(bookingService.createBooking(booking)).thenReturn(booking);
//		
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		verify(bookingService).createBooking(booking);
//		Assert.assertTrue(bookingId.equals(booking.getIdBooking()));
////		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getIdCourt()).equals(bookingCreateDTO.getIdCourt()));
////		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getDateOfBooking())
////				.equals(bookingCreateDTO.getDateOfBooking()));
////		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getHourOfBooking())
////				.equals(bookingCreateDTO.getHourOfBooking()));
//	}

=======
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getIdCourt()).equals(bookingCreateDTO.getIdCourt()));
//		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getDateOfBooking())
//				.equals(bookingCreateDTO.getDateOfBooking()));
//		Assert.assertTrue((bookingFacade.getBookingById(bookingId).getHourOfBooking())
//				.equals(bookingCreateDTO.getHourOfBooking()));
//	}
//
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594
//	@Test
//	public void deleteBookingTest() {
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		bookingFacade.deleteBooking(bookingId);
//		Assert.assertTrue((bookingFacade.getBookingById(bookingId)).equals(null));
//	}
//
//	@Test
//	public void getAllBookingTest() {
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		List<BookingDTO> bookings = bookingFacade.getAllBookings();
//		BookingDTO bookingDTO = bookingFacade.getBookingById(bookingId);
//		Assert.assertTrue(bookings.contains(bookingDTO));
//	}
//
//	@Test
//	public void getBookingsByDateTest() {
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		Assert.assertTrue(bookingFacade.getBookingsByDate(bookingFacade.getBookingById(bookingId).getDateOfBooking())
//				.equals(bookingCreateDTO.getDateOfBooking()));
//	}
//
//	@Test
//	public void getBookingsByUserTest() {
//		Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//		bookingDTO.setIdBooking(bookingId);
//		Assert.assertTrue(bookingFacade.getBookingsByUser(userDTO1).contains(bookingDTO));
//		Assert.assertTrue(bookingFacade.getBookingsByUser(userDTO2).contains(bookingDTO));
//	}
<<<<<<< HEAD

	// @Test
	// public void findByCompetitionCountryBookingTest(){
	// Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
	// List<BookingDTO> bookings =
	// bookingFacade.getBookingsByCountry(CompetitionCountry.CZECH_REPUBLIC);
	// BookingDTO bookingDTO = bookingFacade.getBookingById(bookingId);
	// assertThat(bookings).containsExactly(bookingDTO);
	// }

	@Test
	public void test() {
		Assert.assertTrue(true);
	}
	
}
=======
//
//	// @Test
//	// public void findByCompetitionCountryBookingTest(){
//	// Long bookingId = bookingFacade.createBooking(bookingCreateDTO);
//	// List<BookingDTO> bookings =
//	// bookingFacade.getBookingsByCountry(CompetitionCountry.CZECH_REPUBLIC);
//	// BookingDTO bookingDTO = bookingFacade.getBookingById(bookingId);
//	// assertThat(bookings).containsExactly(bookingDTO);
//	// }
//
//}
>>>>>>> 909cf0492c552c91966fafc1fe4781448d9b5594

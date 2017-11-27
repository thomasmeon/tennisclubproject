package com.frenchies.tennisclub.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.service.spi.ServiceException;
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

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class BookingServiceTest extends AbstractTestNGSpringContextTests {
	@Mock
	private BookingDao bookingDao;

	@Mock
	private TimeService timeService;

	@Autowired
	@InjectMocks
	private BookingService bookingService;
	
	private Booking booking;
	private Booking invalidBooking;
	private User user1;
	private User user2;
	private Calendar calendar = Calendar.getInstance();

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}
	
	@BeforeMethod
	public void generateUsers() {
		// User Inits
		user1 = new User();
		user1.setName("Jean");
		user1.setSurname("Patrick");
		user1.setId(1L);
		user1.setDateOfBirth(calendar.getTime());
		user1.setMail("jean.patrick@mail.com");
		user1.setPhone("+33678787878");
		user1.setAdmin(false);

		user2 = new User();
		user2.setName("Jacques");
		user2.setSurname("Henry");
		user2.setId(2L);
		user2.setDateOfBirth(calendar.getTime());
		user2.setMail("jacques.henry@mail.com");
		user2.setPhone("+33678789090");
		user2.setAdmin(false);
	}
	
	@BeforeMethod
	public void init() {
		calendar.set(2017, 11, 10);
		// Booking Init
		booking = new Booking(1L, user1, user2, calendar.getTime(), Hour24.EIGHT);
		booking.setIdBooking(1L);
		
		invalidBooking = new Booking(1L, user1, user2, calendar.getTime(), Hour24.NINE);
		invalidBooking.setIdBooking(2L);
	}
	
	/*
	 * Creation Tests
	 */

	@Test
	public void createBookingValidTest() {
		doNothing().when(bookingDao).create((Booking) any());
		Booking createdBooking = bookingService.createBooking(booking);

		verify(bookingDao).create(booking);;

		Assert.assertTrue(createdBooking.equals(booking));
	}
	
	@Test(expectedExceptions = IllegalArgumentException.class)
	public void createNullUserTest() {
		bookingService.createBooking(null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullUser1() {
		invalidBooking.setUser1(null);
		bookingService.createBooking(invalidBooking);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullUser2() {
		invalidBooking.setUser2(null);
		bookingService.createBooking(invalidBooking);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullDate() {
		invalidBooking.setDateOfBooking(null);
		bookingService.createBooking(invalidBooking);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullHour() {
		invalidBooking.setHourOfBooking(null);
		bookingService.createBooking(invalidBooking);
	}

	/*
	 * Delete Test
	 */

	@Test
	public void deleteBookingTest() {
		when(bookingDao.findById(booking.getIdBooking())).thenReturn(booking);

		doAnswer(invocation -> {
			booking.setIdBooking(null);
			return null;
		}).when(bookingDao).remove(booking);

		bookingService.deleteBooking(booking);

		verify(bookingDao).remove(booking);
		Assert.assertEquals(booking.getIdBooking(), null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void deleteNullBookingTest() {
		bookingService.deleteBooking(null);
	}
	
	/*
	 * Get Test
	 */

	@Test
	public void getAllBookingsTest() {
		List<Booking> bookingList = new ArrayList<>();
		bookingList.add(booking);

		when(bookingDao.findAll()).thenReturn(bookingList);

		List<Booking> resultBookingList = bookingService.getAllBookings();
		Assert.assertNotNull(resultBookingList);
		Assert.assertEquals(resultBookingList.size(), 1);
		Assert.assertTrue(resultBookingList.contains(booking));

		bookingList.add(invalidBooking);

		when(bookingDao.findAll()).thenReturn(bookingList);

		resultBookingList = bookingService.getAllBookings();
		Assert.assertNotNull(resultBookingList);
		Assert.assertEquals(resultBookingList.size(), 2);
		Assert.assertTrue(resultBookingList.contains(booking));
		Assert.assertTrue(resultBookingList.contains(invalidBooking));
	}
	
	@Test
    public void getBookingByIdTest(){
        when(bookingDao.findById(booking.getIdBooking())).thenReturn(booking);

        Booking foundBooking = bookingService.getBookingById(booking.getIdBooking());
        Assert.assertEquals(foundBooking, booking);
    }
	
	@Test
    public void getBookingByUserTest(){
		List<Booking> bookingList = new ArrayList<>();
        when(bookingDao.findByUser(booking.getUser1())).thenReturn(bookingList);

        List<Booking> listFoundBookings = bookingService.getBookingsByUser(booking.getUser1());
        Assert.assertEquals(listFoundBookings,bookingList);
    }

	@Test
	public void getAllBookingsLastWeekTest() {

		Booking b = new Booking(22l);
		b.setDateOfBooking(timeService.getCurrentTime());

		Calendar cal = Calendar.getInstance();
		cal.set(2017, 25, 11, 0, 0, 0);
		Date fabricatedTime = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		Date weekBeforeFabricatedTime = cal.getTime();

		when(bookingDao.getBookingsCreatedBetween(weekBeforeFabricatedTime, fabricatedTime))
				.thenReturn(Collections.singletonList(b));
		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);

		List<Booking> bookings = bookingService.getAllBookingsLastWeek();
		Assert.assertTrue((bookings.get(0).getIdBooking()).equals(22l));

		Assert.assertTrue(bookings.size() == 1);

	}
	
	
}

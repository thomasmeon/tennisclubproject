//package com.frenchies.tennisclub.service;
//
//import static org.mockito.Matchers.any;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import org.hibernate.service.spi.ServiceException;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import cz.fi.muni.pa165.dao.BookingDao;
//import cz.fi.muni.pa165.entity.Booking;
//import cz.fi.muni.pa165.enums.BookingState;
//import cz.fi.muni.pa165.service.BookingService;
//import cz.fi.muni.pa165.service.TimeService;
//import cz.fi.muni.pa165.service.config.ServiceConfiguration;
//
//public class BookingServiceTest extends BaseServiceTest {
//	@Mock
//	private BookingDao bookindDao;
//
//	@Mock
//	private TimeService timeService;
//
//	@Autowired
//	@InjectMocks
//	private BookingService bookingService;
//
//	@BeforeMethod
//	public void createBookings() {
//		Booking = new Booking();
//
//	}
//
//	@BeforeClass
//	public void setup() throws ServiceException {
//		MockitoAnnotations.initMocks(this);
//	}
//
//	@Test
//	public void getAllBookingsLastWeek() {
//		Calendar cal = Calendar.getInstance();
//		cal.set(2015, 1, 10, 0, 0, 0);
//		Date fabricatedTime = cal.getTime();
//		cal.add(Calendar.DAY_OF_MONTH, -7);
//		Date weekBeforeFabricatedTime = cal.getTime();
//
//		Booking b = new Booking(22);
//		b.setCreated(new Date());
//
//		when(bookindDao.getAllBookingsBetween(any(Date.class), any(Date.class), any()))
//				.thenReturn(Collections.singletonList(o));
//		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);
//
//		List<Booking> orders = bookingService.getAllBookingsLastWeek();
//		Assert.assertEquals(1, orders.size());
//		Assert.assertTrue(orders.get(0).getId().equals(22));
//
//		verify(bookindDao).getAllBookingsBetween(weekBeforeFabricatedTime, fabricatedTime, BookingState.CANCELED);
//	}
//	
//
//
//}

//package com.frenchies.tennisclub.service;
//
//import static org.mockito.Mockito.when;
//
//import java.util.Calendar;
//import java.util.Collections;
//import java.util.Date;
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.service.spi.ServiceException;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
//import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
//import org.testng.Assert;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import com.frenchies.tennisclub.dao.BookingDao;
//import com.frenchies.tennisclub.entity.Booking;
//import com.frenchies.tennisclub.service.config.ServiceConfiguration;
//
//@TestExecutionListeners(TransactionalTestExecutionListener.class)
//@ContextConfiguration(classes = ServiceConfiguration.class)
//@Transactional
//public class BookingServiceTest extends AbstractTestNGSpringContextTests {
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
//	@BeforeClass
//	public void setup() throws ServiceException {
//		MockitoAnnotations.initMocks(this);
//	}
//
////	@BeforeMethod
////	public void createBookings() {
////		Booking b = new Booking();
////
////	}
//
//	
//
//	@Test
//	public void getAllBookingsLastWeek() {
//
//		Booking b = new Booking(22l);
//		b.setDateOfBooking(timeService.getCurrentTime());
//
//		Calendar cal = Calendar.getInstance();
//		cal.set(2017, 25, 11, 0, 0, 0);
//		Date fabricatedTime = cal.getTime();
//		cal.add(Calendar.DAY_OF_MONTH, -7);
//		Date weekBeforeFabricatedTime = cal.getTime();
//
//		when(bookindDao.getBookingsCreatedBetween(weekBeforeFabricatedTime, fabricatedTime))
//				.thenReturn(Collections.singletonList(b));
//		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);
//
//		List<Booking> bookings = bookingService.getAllBookingsLastWeek();
//		Assert.assertTrue((bookings.get(0).getIdBooking()).equals(22l));
//
//		Assert.assertTrue(bookings.size() == 1);
//
//	}
//}
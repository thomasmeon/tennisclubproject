<<<<<<< HEAD
package com.frenchies.tennisclub.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
=======
<<<<<<< HEAD
package com.frenchies.tennisclub.service;

>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
<<<<<<< HEAD
=======
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
<<<<<<< HEAD
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.dao.BookingDao;
import cz.fi.muni.pa165.entity.Booking;
import cz.fi.muni.pa165.enums.BookingState;
import cz.fi.muni.pa165.service.BookingService;
import cz.fi.muni.pa165.service.TimeService;
import cz.fi.muni.pa165.service.config.ServiceConfiguration;

public class BookingServiceTest extends BaseServiceTest {
=======
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeMethod;

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(classes = ServiceConfiguration.class)

public class BookingServiceTest extends AbstractTestNGSpringContextTests {
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6
	@Mock
	private BookingDao bookindDao;

	@Mock
	private TimeService timeService;

	@Autowired
	@InjectMocks
	private BookingService bookingService;

	@BeforeMethod
	public void createBookings() {
<<<<<<< HEAD
		Booking = new Booking();
=======
		Booking b = new Booking();
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6

	}

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllBookingsLastWeek() {
<<<<<<< HEAD
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 1, 10, 0, 0, 0);
=======

		Booking b = new Booking(22l);
		b.setDateOfBooking(timeService.getCurrentTime());

		Calendar cal = Calendar.getInstance();
		cal.set(2017, 25, 11, 0, 0, 0);
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6
		Date fabricatedTime = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		Date weekBeforeFabricatedTime = cal.getTime();

<<<<<<< HEAD
		Booking b = new Booking(22);
		b.setCreated(new Date());

		when(bookindDao.getAllBookingsBetween(any(Date.class), any(Date.class), any()))
				.thenReturn(Collections.singletonList(o));
		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);

		List<Booking> orders = bookingService.getAllBookingsLastWeek();
		Assert.assertEquals(1, orders.size());
		Assert.assertTrue(orders.get(0).getId().equals(22));

		verify(bookindDao).getAllBookingsBetween(weekBeforeFabricatedTime, fabricatedTime, BookingState.CANCELED);
	}
	


}
=======
		when(bookindDao.getBookingsCreatedBetween(weekBeforeFabricatedTime, fabricatedTime))
				.thenReturn(Collections.singletonList(b));
		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);

		List<Booking> bookings = bookingService.getAllBookingsLastWeek();
		Assert.assertEquals(1, bookings.size());
		Assert.assertTrue(bookings.get(0).getIdBooking().equals(22l));

	}

}
=======
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
>>>>>>> 487549bb85cdc489faad900a07821dfa070fdca7
>>>>>>> 1fa0b8ddf6f8af90736ef987dd39596c6345c3d6

package com.frenchies.tennisclub.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(classes = ServiceConfiguration.class)

public class BookingServiceTest extends AbstractTestNGSpringContextTests {
	@Mock
	private BookingDao bookindDao;

	@Mock
	private TimeService timeService;

	@Autowired
	@InjectMocks
	private BookingService bookingService;

	@BeforeMethod
	public void createBookings() {
		Booking b = new Booking();

	}

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllBookingsLastWeek() {

		Booking b = new Booking(22l);
		b.setDateOfBooking(timeService.getCurrentTime());

		Calendar cal = Calendar.getInstance();
		cal.set(2017, 25, 11, 0, 0, 0);
		Date fabricatedTime = cal.getTime();
		cal.add(Calendar.DAY_OF_MONTH, -7);
		Date weekBeforeFabricatedTime = cal.getTime();

		when(bookindDao.getBookingsCreatedBetween(weekBeforeFabricatedTime, fabricatedTime))
				.thenReturn(Collections.singletonList(b));
		when(timeService.getCurrentTime()).thenReturn(fabricatedTime);

		List<Booking> bookings = bookingService.getAllBookingsLastWeek();
		assertThat(bookings.get(0).getIdBooking()).isEqualTo(22l);

		assertThat(1).isEqualTo(bookings.size());

	}

}
package com.frenchies.tenniclub.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.dao.UserDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.Hour24;

/**
 * Test of Booking Dao Impl
 * @author Meon Thomas 473449
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingDaoImplTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	public UserDao userDao;
	
	private User u1;
	private User u2;
	private Booking b1;
	private Booking b2;
	private Booking b3;
	
	private Calendar cal1;

	@BeforeMethod
	public void init() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 1, 2);
		Date date1 = cal.getTime();
		cal.set(2017, 2, 1);
		Date date2 = cal.getTime();
		cal.set(2017, 2, 3);
		Date date3 = cal.getTime();

		u1 = UserDaoImplTest.getSimpleUser();
		u2 = UserDaoImplTest.getSimpleUser2();
		userDao.create(u1);
		userDao.create(u2);
		
		b1 = new Booking((long) 1, u1, u2, date1, Hour24.EIGHT);
		b2 = new Booking((long) 1, u1, u2, date1, Hour24.NINE);
		b3 = new Booking((long) 1, u1, u2, date3, Hour24.TEN);

		bookingDao.create(b1);
		bookingDao.create(b2);
		bookingDao.create(b3);
		
	}
	
	@Test
	public void testCreate() {
		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
	}

	@Test
	public void testUpdate() {
		b1.setHourOfBooking(Hour24.SEVEN);
		bookingDao.update(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()).getHourOfBooking(), b1.getHourOfBooking());
	}

	@Test
	public void testRemove() {
		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);

		bookingDao.remove(b1);

		Assert.assertNull(bookingDao.findById(b1.getIdBooking()));
	}

	@Test
	public void testFindById() {
		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
		Assert.assertEquals(bookingDao.findById(b2.getIdBooking()), b2);
	}
	
	@Test
	public void findByUser() {
		List<Booking> bookings = bookingDao.findByUser(u1);
		Assert.assertEquals(bookings.size(), 3);
	}
	
	@Test
	public void getBookingsCreatedBetween() {
		Calendar cal = Calendar.getInstance();
		cal.set(2017,1, 1);
		Date date1 = cal.getTime();
		cal.set(2017, 2, 2);
		Date date2 = cal.getTime();
		
		Assert.assertEquals(bookingDao.getBookingsCreatedBetween(date1, date2).size(),2);
		
		cal.set(2017, 2, 2);
		Date date3 = cal.getTime();
		
		Assert.assertEquals(bookingDao.getBookingsCreatedBetween(date1, date3).size(),2);
		
		cal.set(2015, 1, 1,0,0,0);
		Date date4 = cal.getTime();
		cal.set(2015, 5, 5,0,0,0);
		Date date5 = cal.getTime();
		Assert.assertEquals(bookingDao.getBookingsCreatedBetween(date4, date5).size(),0);
	}
	
	@Test
	public void getBookingsCreatedBetweenForUser() {
		Calendar cal = Calendar.getInstance();
		cal.set(2016, 1, 1);
		Date date1 = cal.getTime();
		cal.set(2017, 4, 5);
		Date date2 = cal.getTime();
		
		Assert.assertEquals(bookingDao.getBookingsForUserCreatedBetween(date1, date2, u1).size(),3);
		Assert.assertEquals(bookingDao.getBookingsForUserCreatedBetween(date1, date2, u2).size(),3);
		
		cal.set(2015, 1, 1,0,0,0);
		Date date4 = cal.getTime();
		cal.set(2015, 5, 5,0,0,0);
		Date date5 = cal.getTime();
		Assert.assertEquals(bookingDao.getBookingsForUserCreatedBetween(date4, date5, u2).size(),0);
	}
}

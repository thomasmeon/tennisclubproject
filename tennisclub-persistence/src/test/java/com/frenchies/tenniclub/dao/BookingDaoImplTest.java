package com.frenchies.tenniclub.dao;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

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
 * @author ValentinJacquet 473362
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingDaoImplTest extends AbstractTestNGSpringContextTests {

	@Inject
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
		cal1 = Calendar.getInstance();
		cal1.set(1999, 11, 10);

		u1 = UserDaoImplTest.getSimpleUser();
		u2 = UserDaoImplTest.getSimpleUser2();
		userDao.create(u1);
		userDao.create(u2);
		
		b1 = new Booking((long) 1, u1, u2, new Date(20171002), Hour24.EIGHT);
		b2 = new Booking((long) 1, u1, u2, new Date(20171002), Hour24.NINE);
		b3 = new Booking((long) 1, u1, u2, new Date(20171002), Hour24.TEN);

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
	public void testFindAll() {
		Assert.assertEquals(bookingDao.findAll().size(), 3);
		Assert.assertTrue(bookingDao.findAll().contains(b1));
		Assert.assertTrue(bookingDao.findAll().contains(b2));
		Assert.assertTrue(bookingDao.findAll().contains(b3));
	}
}

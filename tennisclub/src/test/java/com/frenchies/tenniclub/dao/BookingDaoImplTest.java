package com.frenchies.tenniclub.dao;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Player;
import com.frenchies.tennisclub.enums.Hour24;

import org.testng.Assert;
import org.testng.annotations.Test;

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

	private Player p1;
	private Player p2;

	// @Before
	// public void init() {
	// bookingDao = new BookingDaoImpl();
	// }

	@Test
	public void testCreate() {
		create2People();

		Booking b1 = new Booking(p1, p2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
	}

	@Test
	public void testUpdate() {
		create2People();

		Booking b1 = new Booking(p1, p2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);
		b1.setHourOfBooking(Hour24.SEVEN);
		bookingDao.update(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()).getHourOfBooking(), b1.getHourOfBooking());
	}

	@Test
	public void testRemove() {
		create2People();

		Booking b1 = new Booking(p1, p2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);

		bookingDao.remove(b1);

		Assert.assertNull(bookingDao.findById(b1.getIdBooking()));
	}

	@Test
	public void testFindById() {
		create2People();

		Booking b1 = new Booking(p1, p2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking(p1, p2, new Date(20171002), Hour24.NINE);

		bookingDao.create(b1);
		bookingDao.create(b2);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
		Assert.assertEquals(bookingDao.findById(b2.getIdBooking()), b2);
	}

	@Test
	public void testFindAll() {
		create2People();

		Booking b1 = new Booking(p1, p2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking(p1, p2, new Date(20171002), Hour24.NINE);
		Booking b3 = new Booking(p2, p1, new Date(20171002), Hour24.TEN);

		bookingDao.create(b1);
		bookingDao.create(b2);
		bookingDao.create(b3);

		Assert.assertEquals(bookingDao.findAll().size(), 3);
		Assert.assertTrue(bookingDao.findAll().contains(b1));
		Assert.assertTrue(bookingDao.findAll().contains(b2));
		Assert.assertTrue(bookingDao.findAll().contains(b3));
	}

	public void create2People() {
		Date c = new Date(20101010);
		p1 = new Player();
		p1.setDateOfBirth(c);
		p1.setMail("jacques.henry@mail.com");
		p1.setName("Henry");
		p1.setSurname("Jacques");
		p1.setLogin("jacques.henry");
		p1.setPassword("blabla");
		//p1.setId((long) 1);
		p1.setPhone("+33625362718");

		p2 = new Player();
		p2.setDateOfBirth(c);
		p2.setMail("jean.pierre@mail.com");
		p2.setName("Pierre");
		p2.setSurname("Jean");
		p2.setLogin("jean.pierre");
		p2.setPassword("blabla");
		//p2.setId((long) 2);
		p2.setPhone("+33725362718");
	}
}

package com.frenchies.tenniclub.dao;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
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

//	private Player p1;
//	private Player p2;

	private long idPlayer1 = (long) 1;
	private long idPlayer2 = (long) 2;
	
	@Test
	public void testCreate() {
//		create2People();
		
		Calendar cal1 = Calendar.getInstance();
        cal1.set(2027, 11, 10);

		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, cal1.getTime(), Hour24.EIGHT);

		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
	}

	@Test
	public void testUpdate() {
//		create2People();

		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);
		b1.setHourOfBooking(Hour24.SEVEN);
		bookingDao.update(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()).getHourOfBooking(), b1.getHourOfBooking());
	}

	@Test
	public void testRemove() {
//		create2People();

		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);

		bookingDao.remove(b1);

		Assert.assertNull(bookingDao.findById(b1.getIdBooking()));
	}

	@Test
	public void testFindById() {
//		create2People();

		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.NINE);

		bookingDao.create(b1);
		bookingDao.create(b2);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
		Assert.assertEquals(bookingDao.findById(b2.getIdBooking()), b2);
	}

	@Test
	public void testFindAll() {
		//create2People();

		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.NINE);
		Booking b3 = new Booking((long) 1, idPlayer2, idPlayer1, new Date(20171002), Hour24.TEN);

		bookingDao.create(b1);
		bookingDao.create(b2);
		bookingDao.create(b3);

		Assert.assertEquals(bookingDao.findAll().size(), 3);
		Assert.assertTrue(bookingDao.findAll().contains(b1));
		Assert.assertTrue(bookingDao.findAll().contains(b2));
		Assert.assertTrue(bookingDao.findAll().contains(b3));
	}

//	public void create2People() {
//		Calendar cal1 = Calendar.getInstance();
//        cal1.set(1995, 10, 10);
//        p1 = new Player();
//		p1.setDateOfBirth(cal1.getTime());
//		p1.setMail("jacques.henry@mail.com");
//		p1.setName("Henry");
//		p1.setSurname("Jacques");
//		p1.setLogin("jacques.henry");
//		p1.setPassword("blabla");
//		//p1.setId((long) 1);
//		p1.setPhone("+33625362718");
//
//		p2 = new Player();
//		p2.setDateOfBirth(cal1.getTime());
//		p2.setMail("jean.pierre@mail.com");
//		p2.setName("Pierre");
//		p2.setSurname("Jean");
//		p2.setLogin("jean.pierre");
//		p2.setPassword("blabla");
//		//p2.setId((long) 2);
//		p2.setPhone("+33725362718");
//	}
}

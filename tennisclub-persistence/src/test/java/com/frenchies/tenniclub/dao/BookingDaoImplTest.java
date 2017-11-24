package com.frenchies.tenniclub.dao;

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
import com.frenchies.tennisclub.entity.Player;
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

//	private long idPlayer1 = (long) 1;
//	private long idPlayer2 = (long) 2;
	
	private Player player1;
	private Player player2;
	
	@Test
	public void testCreate() {
		
		//Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, cal1.getTime(), Hour24.EIGHT);
        Booking b1 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.EIGHT);

		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
	}

	@Test
	public void testUpdate() {
		

		//Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
		Booking b1 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.EIGHT);
		
		bookingDao.create(b1);
		b1.setHourOfBooking(Hour24.SEVEN);
		bookingDao.update(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()).getHourOfBooking(), b1.getHourOfBooking());
	}

	@Test
	public void testRemove() {
		
		
		//Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
		Booking b1 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.EIGHT);
		
		bookingDao.create(b1);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);

		bookingDao.remove(b1);

		Assert.assertNull(bookingDao.findById(b1.getIdBooking()));
	}

	@Test
	public void testFindById() {
		

//		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
//		Booking b2 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.NINE);
		
		Booking b1 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.NINE);

		bookingDao.create(b1);
		bookingDao.create(b2);

		Assert.assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
		Assert.assertEquals(bookingDao.findById(b2.getIdBooking()), b2);
	}

	@Test
	public void testFindAll() {
		

//		Booking b1 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.EIGHT);
//		Booking b2 = new Booking((long) 1, idPlayer1, idPlayer2, new Date(20171002), Hour24.NINE);
//		Booking b3 = new Booking((long) 1, idPlayer2, idPlayer1, new Date(20171002), Hour24.TEN);
		
		Booking b1 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.EIGHT);
		Booking b2 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.NINE);
		Booking b3 = new Booking((long) 1, player1, player2, new Date(20171002), Hour24.TEN);

		bookingDao.create(b1);
		bookingDao.create(b2);
		bookingDao.create(b3);

		Assert.assertEquals(bookingDao.findAll().size(), 3);
		Assert.assertTrue(bookingDao.findAll().contains(b1));
		Assert.assertTrue(bookingDao.findAll().contains(b2));
		Assert.assertTrue(bookingDao.findAll().contains(b3));
	}
}

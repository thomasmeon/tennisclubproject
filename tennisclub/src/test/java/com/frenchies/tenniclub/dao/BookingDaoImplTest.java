package com.frenchies.tenniclub.dao;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.dao.BookingDaoImpl;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Player;
import com.frenchies.tennisclub.enums.Hour24;

@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class BookingDaoImplTest {
	
	@Inject
	private BookingDao bookingDao;
	
	@Before
	public void init() {
		bookingDao = new BookingDaoImpl();
	}
	
	@Test
	public void testCreate() {
		Booking b1 = new Booking((long) 1);
		b1.setHourOfBooking(Hour24.EIGHT);
		Player p1 = new Player();
		p1.setName("Jacques");
		b1.setPeople(p1);
		
		bookingDao.create(b1);
		
		assertEquals(bookingDao.findById(b1.getIdBooking()), b1);
		
		System.out.println("FIN");
	}
//	
//	@Test
//	public void testUpdate() {
//		
//	}
//	
//	@Test
//	public void testDelete() {
//		
//	}
}

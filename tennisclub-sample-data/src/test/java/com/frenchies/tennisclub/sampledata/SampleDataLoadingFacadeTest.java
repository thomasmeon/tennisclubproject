package com.frenchies.tennisclub.sampledata;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.dao.UserDao;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.service.UserService;
import com.frenchies.tennisclub.sampledata.TennisClubWithSampleDataConfiguration;

/**
 * Tests data loading.
 *
 * @author Meon Thomas 473449
 */
@ContextConfiguration(classes = { TennisClubWithSampleDataConfiguration.class })
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class SampleDataLoadingFacadeTest extends AbstractTestNGSpringContextTests {

	final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeTest.class);

	@Autowired
	public BookingDao bookingDao;

	@Autowired
	public CourtDao courtDao;

	@Autowired
	public UserDao userDao;

	@Autowired
	public UserService userService;

	@Autowired
	public SampleDataLoadingFacade sampleDataLoadingFacade;

	@PersistenceContext
	private EntityManager em;

	@Test
	public void createSampleData() throws IOException {
		log.debug("starting test");

		Assert.assertTrue(bookingDao.findAll().size() > 0, "no bookings");

		Assert.assertTrue(courtDao.findAll().size() > 0, "no courts");

		System.out.println(userDao.findAll().size());

		User admin = userService.getAllUsers().stream().filter(userService::isAdmin).findFirst().get();
		Assert.assertEquals(true, userService.authenticate(admin, "admin"));

	}

}

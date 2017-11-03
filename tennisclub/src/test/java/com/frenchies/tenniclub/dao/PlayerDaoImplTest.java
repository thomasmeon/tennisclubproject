package com.frenchies.tenniclub.dao;

import java.util.Calendar;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.PlayerDao;
import com.frenchies.tennisclub.entity.Player;

/**
 * Test of Player Dao Impl
 * 
 * @author ValentinJacquet 473362
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PlayerDaoImplTest extends AbstractTestNGSpringContextTests {

	@Inject
	private PlayerDao playerDao;

	private Player p1;
	private Player p2;
	private Player p3;
	private Calendar cal1;

	@BeforeTest
	public void init() {
		cal1 = Calendar.getInstance();
		cal1.set(1999, 11, 10);
	}

	@Test
	public void testCreate() {
		create1People();

		playerDao.create(p1);

		Assert.assertEquals(playerDao.findById(p1.getId()), p1);
	}

	@Test
	public void testUpdate() {
		create1People();

		playerDao.create(p1);
		p1.setName("Jacques Patrick");
		;
		playerDao.update(p1);

		Assert.assertEquals(playerDao.findById(p1.getId()).getName(), p1.getName());
	}

	@Test
	public void testRemove() {
		create1People();

		playerDao.create(p1);

		Assert.assertEquals(playerDao.findById(p1.getId()), p1);

		playerDao.remove(p1);

		Assert.assertNull(playerDao.findById(p1.getId()));
	}

	@Test
	public void testFindById() {
		create2People();

		playerDao.create(p1);
		playerDao.create(p2);

		Assert.assertEquals(playerDao.findById(p1.getId()), p1);
		Assert.assertEquals(playerDao.findById(p2.getId()), p2);
	}

	@Test
	public void testFindAll() {
		create3People();

		playerDao.create(p1);
		playerDao.create(p2);
		playerDao.create(p3);

		Assert.assertEquals(playerDao.findAll().size(), 3);
		Assert.assertTrue(playerDao.findAll().contains(p1));
		Assert.assertTrue(playerDao.findAll().contains(p2));
		Assert.assertTrue(playerDao.findAll().contains(p3));
	}

	public void create1People() {

		p1 = new Player();
		p1.setDateOfBirth(cal1.getTime());
		p1.setMail("jacques.henry@mail.com");
		p1.setName("Henry");
		p1.setSurname("Jacques");
		p1.setLogin("jacques.henry");
		p1.setPassword("blabla");
		p1.setPhone("+33625362718");
	}

	public void create2People() {
		create1People();

		p2 = new Player();
		p2.setDateOfBirth(cal1.getTime());
		p2.setMail("jean.pierre@mail.com");
		p2.setName("Pierre");
		p2.setSurname("Jean");
		p2.setLogin("jean.pierre");
		p2.setPassword("blabla");
		p2.setPhone("+33725362718");
	}

	public void create3People() {
		create2People();

		p3 = new Player();
		p3.setDateOfBirth(cal1.getTime());
		p3.setMail("mathieu.françois@mail.com");
		p3.setName("François");
		p3.setSurname("Mathieu");
		p3.setLogin("mathieu.françois");
		p3.setPassword("blabla");
		p3.setPhone("+33729362718");
	}
}

package com.frenchies.tenniclub.dao;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.PeopleDao;
import com.frenchies.tennisclub.entity.Player;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Test of People Dao Impl
 * @author ValentinJacquet 473362
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class PeopleDaoImplTest extends AbstractTestNGSpringContextTests {

	@Inject
	private PeopleDao peopleDao;
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Date c = new Date(20101010);


	@Test
	public void testCreate() {
		create1People();

		peopleDao.create(p1);

		Assert.assertEquals(peopleDao.findById(p1.getId()), p1);
	}

	@Test
	public void testUpdate() {
		create1People();
		
		peopleDao.create(p1);
		p1.setName("Jacques Patrick");;
		peopleDao.update(p1);

		Assert.assertEquals(peopleDao.findById(p1.getId()).getName(), p1.getName());
	}

	@Test
	public void testRemove() {
		create1People();
		
		peopleDao.create(p1);

		Assert.assertEquals(peopleDao.findById(p1.getId()), p1);

		peopleDao.remove(p1);

		Assert.assertNull(peopleDao.findById(p1.getId()));
	}

	@Test
	public void testFindById() {
		create2People();

		peopleDao.create(p1);
		peopleDao.create(p2);

		Assert.assertEquals(peopleDao.findById(p1.getId()), p1);
		Assert.assertEquals(peopleDao.findById(p2.getId()), p2);
	}

	@Test
	public void testFindAll() {
		create2People();

		peopleDao.create(p1);
		peopleDao.create(p2);
		peopleDao.create(p3);

		Assert.assertEquals(peopleDao.findAll().size(), 3);
		Assert.assertTrue(peopleDao.findAll().contains(p1));
		Assert.assertTrue(peopleDao.findAll().contains(p2));
		Assert.assertTrue(peopleDao.findAll().contains(p3));
	}
	
	public void create1People() {
		p1 = new Player();
		p1.setDateOfBirth(c);
		p1.setMail("jacques.henry@mail.com");
		p1.setName("Henry");
		p1.setSurname("Jacques");
		p1.setLogin("jacques.henry");
		p1.setPassword("blabla");
		p1.setId((long) 1);
		p1.setPhone("+33625362718");
	}

	public void create2People() {
		create1People();

		p2 = new Player();
		p2.setDateOfBirth(c);
		p2.setMail("jean.pierre@mail.com");
		p2.setName("Pierre");
		p2.setSurname("Jean");
		p2.setLogin("jean.pierre");
		p2.setPassword("blabla");
		p2.setId((long) 2);
		p2.setPhone("+33725362718");
	}
	
	public void create3People() {
		create2People();
		
		p3 = new Player();
		p3.setDateOfBirth(c);
		p3.setMail("mathieu.françois@mail.com");
		p3.setName("François");
		p3.setSurname("Mathieu");
		p3.setLogin("mathieu.françois");
		p3.setPassword("blabla");
		p3.setId((long) 2);
		p3.setPhone("+33729362718");
	}
}

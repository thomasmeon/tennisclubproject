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
import com.frenchies.tennisclub.dao.ManagerDao;
import com.frenchies.tennisclub.entity.Manager;

/**
 * Test of Manager Dao Impl
 * 
 * @author ValentinJacquet 473362
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class ManagerDaoImplTest extends AbstractTestNGSpringContextTests {

	@Inject
	private ManagerDao managerDao;

	private Manager m1;
	private Manager m2;
	private Manager m3;
	private Calendar cal1;

	@BeforeTest
	public void init() {
		cal1 = Calendar.getInstance();
		cal1.set(1999, 11, 10);
	}

	@Test
	public void testCreate() {
		create1People();

		managerDao.create(m1);

		Assert.assertEquals(managerDao.findById(m1.getId()), m1);
	}

	@Test
	public void testUpdate() {
		create1People();

		managerDao.create(m1);
		m1.setName("Jacques Patrick");
		;
		managerDao.update(m1);

		Assert.assertEquals(managerDao.findById(m1.getId()).getName(), m1.getName());
	}

	@Test
	public void testRemove() {
		create1People();

		managerDao.create(m1);

		Assert.assertEquals(managerDao.findById(m1.getId()), m1);

		managerDao.remove(m1);

		Assert.assertNull(managerDao.findById(m1.getId()));
	}

	@Test
	public void testFindById() {
		create2People();

		managerDao.create(m1);
		managerDao.create(m2);

		Assert.assertEquals(managerDao.findById(m1.getId()), m1);
		Assert.assertEquals(managerDao.findById(m2.getId()), m2);
	}

	@Test
	public void testFindAll() {
		create3People();

		managerDao.create(m1);
		managerDao.create(m2);
		managerDao.create(m3);

		Assert.assertEquals(managerDao.findAll().size(), 3);
		Assert.assertTrue(managerDao.findAll().contains(m1));
		Assert.assertTrue(managerDao.findAll().contains(m2));
		Assert.assertTrue(managerDao.findAll().contains(m3));
	}

	public void create1People() {

		m1 = new Manager();
		m1.setMail("jacques.henry@mail.com");
		m1.setName("Henry");
		m1.setSurname("Jacques");
		m1.setLogin("jacques.henry");
		m1.setPassword("blabla");
	}

	public void create2People() {
		create1People();

		m2 = new Manager();
		m2.setMail("jean.pierre@mail.com");
		m2.setName("Pierre");
		m2.setSurname("Jean");
		m2.setLogin("jean.pierre");
		m2.setPassword("blabla");
	}

	public void create3People() {
		create2People();

		m3 = new Manager();
		m3.setMail("mathieu.françois@mail.com");
		m3.setName("François");
		m3.setSurname("Mathieu");
		m3.setLogin("mathieu.françois");
		m3.setPassword("blabla");
	}
}

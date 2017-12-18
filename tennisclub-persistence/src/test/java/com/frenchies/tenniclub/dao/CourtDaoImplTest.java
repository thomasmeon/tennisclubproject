package com.frenchies.tenniclub.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;

/**
 * Test of Court Dao Impl
 * @author ValentinJacquet 473362
 *
 */
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class CourtDaoImplTest extends AbstractTestNGSpringContextTests {

	@Autowired
	private CourtDao courtDao;

	@Test
	public void testCreate() {
		Court c1 = new Court(Status.AVAILABLE,CourtType.CLAY,49,40);

		courtDao.create(c1);

		Assert.assertEquals(courtDao.findById(c1.getIdCourt()), c1);
	}

	@Test
	public void testUpdate() {
		Court c1 = new Court(Status.AVAILABLE,CourtType.CLAY,49,40);
		
		courtDao.create(c1);
		c1.setType(CourtType.HARD);;
		courtDao.update(c1);

		Assert.assertEquals(courtDao.findById(c1.getIdCourt()).getType(), c1.getType());
	}

	@Test
	public void testRemove() {
		Court c1 = new Court(Status.AVAILABLE,CourtType.CLAY,49,40);
		
		courtDao.create(c1);

		Assert.assertEquals(courtDao.findById(c1.getIdCourt()), c1);

		courtDao.remove(c1);

		Assert.assertNull(courtDao.findById(c1.getIdCourt()));
	}

	@Test
	public void testFindById() {
		Court c1 = new Court(Status.AVAILABLE,CourtType.CLAY,49,40);
		Court c2 = new Court(Status.AVAILABLE,CourtType.HARD,47,40);

		courtDao.create(c1);
		courtDao.create(c2);

		Assert.assertEquals(courtDao.findById(c1.getIdCourt()), c1);
		Assert.assertEquals(courtDao.findById(c2.getIdCourt()), c2);
	}

	@Test
	public void testFindAll() {
		Court c1 = new Court(Status.AVAILABLE,CourtType.CLAY,49,40);
		Court c2 = new Court(Status.AVAILABLE,CourtType.HARD,47,40);
		Court c3 = new Court(Status.AVAILABLE,CourtType.HARD,45,40);

		courtDao.create(c1);
		courtDao.create(c2);
		courtDao.create(c3);

		Assert.assertEquals(courtDao.findAll().size(), 3);
		Assert.assertTrue(courtDao.findAll().contains(c1));
		Assert.assertTrue(courtDao.findAll().contains(c2));
		Assert.assertTrue(courtDao.findAll().contains(c3));
	}
}

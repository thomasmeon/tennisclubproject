package com.frenchies.tennisclub.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

/**
 * Basic tests for  Court service implementations
 *
 * @author CorentinDore 473308
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class CourtServiceTest {

	@Mock
	private CourtDao courtDao;

	@Autowired
	@InjectMocks
	private CourtServiceImpl courtService;
	private Court c;
	private Court c2;

	protected CourtType newCourtType;

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	// INIT

	@BeforeMethod
	public void init() {
		c = new Court(Status.AVAILABLE, CourtType.CARPET, 234, 34);

		c.setIdCourt(69l);
		newCourtType = (CourtType.GRASS);
	}

	// UPDATE TEST
	@Test
	public void changeType() {
		// setup
		doAnswerSetRoleWhenUpdate(newCourtType);

		when(courtDao.findById(c.getIdCourt())).thenReturn(c);

		// Method call
		courtService.changeCourtType(c, newCourtType);

		// verify
		Assert.assertTrue(c.getType().equals(newCourtType));

	}

	private void doAnswerSetRoleWhenUpdate(CourtType newCourtType) {
		doAnswer(invocation -> {
			c.setType(newCourtType);
			return null;
		}).when(courtDao).update(c);

		doAnswer(invocation -> {
			c.setIdCourt(null);
			return null;
		}).when(courtDao).remove(c);

	}

	// GET TEST

	@Test
	void getByIdTest() {
		when(courtDao.findById(c.getIdCourt())).thenReturn(c);

		Court gotCourt = courtService.getCourtById(c.getIdCourt());
		Assert.assertEquals(gotCourt, c);
	}

	@Test
	void getAllTest() {
		List<Court> courtList = new ArrayList<>();
		courtList.add(c);

		when(courtDao.findAll()).thenReturn(courtList);

		List<Court> resultCourtList = courtService.getAllCourts();
		Assert.assertNotNull(resultCourtList);
		Assert.assertEquals(resultCourtList.size(), 1);
		Assert.assertTrue(resultCourtList.contains(c));

		courtList.add(c2);

		when(courtDao.findAll()).thenReturn(courtList);

		resultCourtList = courtService.getAllCourts();
		Assert.assertNotNull(resultCourtList);
		Assert.assertEquals(resultCourtList.size(), 2);
		Assert.assertTrue(resultCourtList.contains(c));
		Assert.assertTrue(resultCourtList.contains(c2));
	}

	// CREATE/DELETE TEST

	@Test
	public void deleteTest() {
		courtService.createCourt(c);
		when(courtDao.findById(c.getIdCourt())).thenReturn(c);

		doAnswer(invocation -> {
			c.setIdCourt(null);
			return null;
		}).when(courtDao).remove(c);

		courtService.deleteCourt(c);

		verify(courtDao).remove(c);
		Assert.assertEquals(c.getIdCourt(), null);
	}

	@Test
	void createTest() {
		doNothing().when(courtDao).create(any());
		Court verifyCourt = courtService.createCourt(c);
		verify(courtDao).create(c);

		Assert.assertEquals(verifyCourt, c);
	}

}
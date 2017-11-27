package com.frenchies.tennisclub.service;

import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Status;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

/**
 * Basic tests for service implementations
 *
 * @author CorentinDore 473308
 */

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@ContextConfiguration(classes = ServiceConfiguration.class)
@Transactional
public class CourtServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	@InjectMocks
	private CourtService courtService;
	private Court c;
	protected CourtType newCourtType;

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void init() {
		c = new Court(Status.AVAILABLE, CourtType.CARPET, 234, 34);
		courtService.createCourt(c);

		newCourtType = (CourtType.GRASS);
	}

	@Test
	public void changeCourtType() {

		courtService.changeCourtType(c, newCourtType);

		Assert.assertTrue(c.getCourtType().equals(newCourtType));
		

	}

}
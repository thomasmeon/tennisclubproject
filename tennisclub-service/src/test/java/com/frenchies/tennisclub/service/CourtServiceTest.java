package com.frenchies.tennisclub.service;

import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

import static org.assertj.core.api.Assertions.assertThat;



/**
 * Basic tests for facade implementations using a mock of the service layer.
 *
 * @author CorentinDore 473308
 */

@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
@ContextConfiguration(classes = ServiceConfiguration.class)

public class CourtServiceTest extends AbstractTestNGSpringContextTests {
	@Mock
	private CourtDao courtDao;

	@Autowired
	@InjectMocks
	private CourtService courtService;

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}


	@Test
	public void changeType(Court c, CourtType newCourtType) {

		courtService.changeCourtType(c, newCourtType);

		assertThat(c.getCourtType()).isEqualTo(newCourtType);

	}

}

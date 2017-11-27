package com.frenchies.tennisclub.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

import java.util.Calendar;

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
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dao.UserDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.entity.User;
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
public class UserServiceTest extends AbstractTestNGSpringContextTests {

	@Autowired
	@InjectMocks
	private CourtService courtService;
	private Court c;
	protected CourtType newCourtType;


	@Mock
    private UserDao userDao;

    @Autowired
    @InjectMocks
    private UserService userService;

    private User validUser;
    private User invalidUser;

    private Calendar calendar = Calendar.getInstance();

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void init() {
		c = new Court(Status.AVAILABLE, CourtType.CARPET, 234, 34);
		courtService.createCourt(c);

		newCourtType = (CourtType.GRASS);

		calendar.set(1980, Calendar.NOVEMBER, 7);

        //User Inits
        validUser = new User();
        validUser.setName("Jean");
        validUser.setSurname("Patrick");
        validUser.setId(1L);
        validUser.setDateOfBirth(calendar.getTime());
        validUser.setMail("jean.patrick@mail.com");
        validUser.setPhone("+33678787878");
        validUser.setAdmin(true);

        invalidUser = new User();
        invalidUser.setName("Jacques");
        invalidUser.setSurname("Henry");
        invalidUser.setId(2L);
        invalidUser.setDateOfBirth(calendar.getTime());
        invalidUser.setMail("jacques.henry@mail.com");
        invalidUser.setPhone("+33678789090");
        invalidUser.setAdmin(true);
	}

	@Test
	public void changeCourtType() {

		Assert.assertTrue(true);
		

	}

	@Test
    void createUserValidTest() {
		doNothing().when(userDao).create(null);
        User createdUser = userService.registerUser(validUser,"blabla");

        verify(userDao).create(validUser);

        Assert.assertTrue(createdUser.equals(validUser));
    }

}
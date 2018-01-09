package com.frenchies.tennisclub.service;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
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

import com.frenchies.tennisclub.dao.UserDao;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

/**
 * Basic tests for service implementations
 *
 * @author CorentinDore 473308
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class UserServiceTest {

	@Mock
	private UserDao userDao;

	@Autowired
	@InjectMocks
	private UserServiceImpl userService;

	private User validUser;
	private User invalidUser;

	private Calendar calendar = Calendar.getInstance();

	@BeforeClass
	public void setup() throws ServiceException {
		MockitoAnnotations.initMocks(this);
	}

	@BeforeMethod
	public void init() {
		// User Inits
		validUser = new User();
		validUser.setName("Jean");
		validUser.setSurname("Patrick");
		validUser.setId(1L);
		validUser.setDateOfBirth(calendar.getTime());
		validUser.setMail("jean.patrick@mail.com");
		validUser.setPhone("+33678787878");
		validUser.setAdmin(true);
		validUser.setTeacher(true);

		invalidUser = new User();
		invalidUser.setName("Jacques");
		invalidUser.setSurname("Henry");
		invalidUser.setId(2L);
		invalidUser.setDateOfBirth(calendar.getTime());
		invalidUser.setMail("jacques.henry@mail.com");
		invalidUser.setPhone("+33678789090");
		invalidUser.setAdmin(false);
	}

	/*
	 * Creation Tests
	 */

	@Test
	public void createUserValidTest() {
		doNothing().when(userDao).create((User) any());
		User createdUser = userService.registerUser(validUser, "blabla");

		verify(userDao).create(validUser);

		Assert.assertTrue(createdUser.equals(validUser));
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void createNullUserTest() {
		userService.registerUser(null, "blabla");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullName() {
		invalidUser.setName(null);
		userService.registerUser(invalidUser, "blabla");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullSurname() {
		invalidUser.setSurname(null);
		userService.registerUser(invalidUser, "blabla");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullMail() {
		invalidUser.setMail(null);
		userService.registerUser(invalidUser, "blabla");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullPhone() {
		invalidUser.setPhone(null);
		userService.registerUser(invalidUser, "blabla");
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void testCreateUserNullDateOfBirth() {
		invalidUser.setDateOfBirth(null);
		userService.registerUser(invalidUser, "blabla");
	}

	/*
	 * Update Test
	 */

	@Test
	public void updateUserTest() {
		String newName = "Paul";
		validUser.setName(newName);
		userService.update(validUser);
		Assert.assertTrue(validUser.getName().equals(newName));
	}

	/*
	 * Delete Test
	 */

	@Test
	public void deleteUserTest() {
		when(userDao.findById(validUser.getId())).thenReturn(validUser);

		doAnswer(invocation -> {
			validUser.setId(null);
			return null;
		}).when(userDao).remove(validUser);

		userService.delete(validUser);

		verify(userDao).remove(validUser);
		Assert.assertEquals(validUser.getId(), null);
	}

	@Test(expectedExceptions = IllegalArgumentException.class)
	public void deleteNullUserTest() {
		userService.delete(null);
	}

	/*
	 * Get Test
	 */

	@Test
	public void getAllUsersTest() {
		List<User> userList = new ArrayList<>();
		userList.add(validUser);

		when(userDao.findAll()).thenReturn(userList);

		List<User> resultUserList = userService.getAllUsers();
		Assert.assertNotNull(resultUserList);
		Assert.assertEquals(resultUserList.size(), 1);
		Assert.assertTrue(resultUserList.contains(validUser));

		userList.add(invalidUser);

		when(userDao.findAll()).thenReturn(userList);

		resultUserList = userService.getAllUsers();
		Assert.assertNotNull(resultUserList);
		Assert.assertEquals(resultUserList.size(), 2);
		Assert.assertTrue(resultUserList.contains(validUser));
		Assert.assertTrue(resultUserList.contains(invalidUser));
	}
	
	@Test
    public void getUserByIdTest(){
        when(userDao.findById(validUser.getId())).thenReturn(validUser);

        User foundUser = userService.getUserById(validUser.getId());
        Assert.assertEquals(foundUser, validUser);
    }
	
	@Test
    public void getUserByNameTest(){
        when(userDao.findUserByName(validUser.getName())).thenReturn(validUser);

        User foundUser = userService.getUserByName(validUser.getName());
        Assert.assertEquals(foundUser, validUser);
    }
	
	@Test
    public void getUserByEmailTest(){
        when(userDao.findUserByEmail(validUser.getMail())).thenReturn(validUser);

        User foundUser = userService.getUserByEmail(validUser.getMail());
        Assert.assertEquals(foundUser, validUser);
    }
	
	/*
	 * Admin test
	 */
	@Test
	public void isAdminTest() {
		when(userDao.findUserByName(validUser.getName())).thenReturn(validUser);
		
		Assert.assertEquals(userService.isAdmin(validUser), validUser.isAdmin());
	}
	
	@Test
	public void isAdminIdTest() {
		when(userDao.findUserByName(validUser.getName())).thenReturn(validUser);
		
		Assert.assertEquals(userService.isAdmin(validUser.getId()), validUser.isAdmin());
	}
	
	/*
	 * Teacher test
	 */
	@Test
	public void isTeacherTest() {
		when(userDao.findUserByName(validUser.getName())).thenReturn(validUser);
		
		Assert.assertEquals(userService.isTeacher(validUser), validUser.isTeacher());
	}
	
	@Test
	public void isTeacherIdTest() {
		when(userDao.findUserByName(validUser.getName())).thenReturn(validUser);
		
		Assert.assertEquals(userService.isTeacher(validUser.getId()), validUser.isTeacher());
	}
	
	/*
	 * authentication Test
	 */
	
	@Test
	public void authenticateTest() {
		User createdUser = userService.registerUser(validUser, "blabla");
		verify(userDao).create(validUser);
		Assert.assertTrue(userService.authenticate(createdUser, "blabla"));
	}

}
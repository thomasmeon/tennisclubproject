package com.frenchies.tennisclub.facade;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.UserService;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;
import com.frenchies.tennisclub.service.facade.UserFacadeImpl;

@ContextConfiguration(classes = ServiceConfiguration.class)
public class UserFacadeTest {
	@Mock
	private BeanMappingService beanMappingService;

	@Mock
	private UserService userService;

	@Autowired
	@InjectMocks
	private UserFacadeImpl userFacade;

	private User validUser;

	private UserCreateDTO userCreateDTO;

	private UserDTO validUserDTO;

	private UserAuthenticateDTO userAuthDTO;

	@BeforeClass
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	
	public void initUser(String Name, String Surname, String Mail, Date dateOfBooking, String Phone, boolean admin) {
		

		userCreateDTO = new UserCreateDTO();
		userCreateDTO.setName(Name);
		userCreateDTO.setSurname(Surname);
		userCreateDTO.setMail(Mail);
		userCreateDTO.setDateOfBirth(dateOfBooking);
		userCreateDTO.setPhone(Phone);
		userCreateDTO.setPasswordHash(null);
		userCreateDTO.setAdmin(admin);

		validUser = new User();
		validUser.setName(Name);
		validUser.setSurname(Surname);
		validUser.setMail(Mail);
		validUser.setDateOfBirth(dateOfBooking);
		validUser.setPhone(Phone);
		validUser.setPasswordHash(null);
		validUser.setAdmin(admin);
		validUser.setId(10L);
		when(beanMappingService.mapTo(userCreateDTO, User.class)).thenReturn(validUser);

		validUserDTO = new UserDTO();
		validUserDTO.setName(Name);
		validUserDTO.setSurname(Surname);
		validUserDTO.setMail(Mail);
		validUserDTO.setDateOfBirth(dateOfBooking);
		validUserDTO.setPhone(Phone);
		validUserDTO.setPasswordHash(null);
		validUserDTO.setAdmin(admin);
		validUserDTO.setId(10L);

		
	}
	
	@BeforeMethod
	public void init()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(1995, Calendar.JULY, 29);
		Date date1 = cal.getTime();
		initUser("Jean", "Pierre", "jean.pierre@mail.com", date1, "+33654545454",false);
		
		userAuthDTO = new UserAuthenticateDTO();
	}

	/**
	 * Creation Test
	 */
	@Test
	void createUserTest() {
		when(userService.registerUser(validUser, "blabla")).thenReturn(validUser);

		Long createdId = userFacade.createUser(userCreateDTO, "blabla");
		verify(userService).registerUser(validUser, "blabla");
		Assert.assertTrue((createdId).equals(validUser.getId()));
	}

//	@Test
//	void updateUserTest() throws Exception {
//		validUserDTO.setMail("jpierre@tozz.fr");
//		userFacade.updateUser(validUserDTO);
//		UserDTO updatedUser = userFacade.getUserById(validUserDTO.getId());
//		Assert.assertTrue(updatedUser.getMail().equals(validUserDTO.getMail()));
//	}

	@Test
	void deleteUserTest() {
		Long id = 10L;

		when(userService.getUserById(id)).thenReturn(validUser);

		userFacade.deleteUser(id);
		verify(userService, times(1)).delete(validUser);
	}

	@Test
	void findUserByIdTest() {
		when(beanMappingService.mapTo(validUser, UserDTO.class)).thenReturn(validUserDTO);
		when(userService.getUserById(10L)).thenReturn(validUser);

		UserDTO resUserDTO = userFacade.getUserById(validUser.getId());
		Assert.assertTrue((resUserDTO).equals(validUserDTO));
	}

	@Test
	void findUserByNameTest() {
		when(beanMappingService.mapTo(validUser, UserDTO.class)).thenReturn(validUserDTO);
		when(userService.getUserByName("Jean")).thenReturn(validUser);

		UserDTO resUserDTO = userFacade.getUserByName(validUser.getName());
		Assert.assertTrue(resUserDTO.equals(validUserDTO));
	}

	@Test
	void findAllUserTest() {
		List<User> usersList = new ArrayList<>();
		usersList.add(validUser);
		when(userService.getAllUsers()).thenReturn(usersList);

		List<UserDTO> usersDTOList = new ArrayList<>();
		usersDTOList.add(validUserDTO);
		when(beanMappingService.mapTo(usersList, UserDTO.class)).thenReturn(usersDTOList);

		List<UserDTO> resListUserDTO = new ArrayList<>(userFacade.getAllUsers());

		verify(userService).getAllUsers();
		Assert.assertTrue((resListUserDTO.size()) == 1);
		Assert.assertTrue(resListUserDTO.contains(validUserDTO));
	}

	@Test
	void isAdminTest() {
		UserDTO uTemp = userFacade.getUserById(validUser.getId());

		Assert.assertEquals(userFacade.isAdmin(uTemp.getId()), validUserDTO.isAdmin());
	}

//	@Test
//	void authenticateTest() {
//		when(userService.registerUser(validUser, "blabla")).thenReturn(validUser);
//
//		Long createdUserDTO = userFacade.createUser(userCreateDTO, "blabla");
//		Assert.assertEquals(createdUserDTO, validUser.getId());
//		verify(userService).registerUser(validUser, "blabla");
//		Assert.assertTrue(userFacade.authenticate(userFacade.getUserById(createdUserDTO), "blabla"));
//	}
}

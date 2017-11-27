package com.frenchies.tennisclub.facade;

import static org.mockito.Mockito.doNothing;
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

    @BeforeMethod
    void init(){
    	Calendar cal = Calendar.getInstance();
        cal.set(1995, Calendar.JULY, 29);
        Date date1 = cal.getTime();
    	
    	userCreateDTO = new UserCreateDTO();
        userCreateDTO.setName("Jean");
        userCreateDTO.setSurname("Pierre");
        userCreateDTO.setMail("jean.pierre@mail.com");
        userCreateDTO.setDateOfBirth(date1);
        userCreateDTO.setPhone("+33054678976");
        userCreateDTO.setPasswordHash(null);

        validUser = new User();
        validUser.setName("Jean");
        validUser.setSurname("Pierre");
        validUser.setMail("jean.pierre@mail.com");
        validUser.setDateOfBirth(date1);
        validUser.setPhone("+33054678976");
        validUser.setPasswordHash(null);
        validUser.setAdmin(true);
        validUser.setId(10L);
        when(beanMappingService.mapTo(userCreateDTO, User.class)).thenReturn(validUser);

        validUserDTO =  new UserDTO();
        validUserDTO.setName("Jean");
        validUserDTO.setSurname("Pierre");
        validUserDTO.setMail("jean.pierre@mail.com");
        validUserDTO.setDateOfBirth(date1);
        validUserDTO.setPhone("+33054678976");
        validUserDTO.setPasswordHash(null);
        validUserDTO.setId(10L);
        
        userAuthDTO = new UserAuthenticateDTO();
        userAuthDTO.setUserId(10L);
        userAuthDTO.setPassword("blabla");
    }
    
    @Test
    void createUserTest(){
        when(userService.registerUser(validUser,"blabla")).thenReturn(validUser);

        Long createdId = userFacade.createUser(userCreateDTO,"blabla");
        verify(userService).registerUser(validUser, "blabla");
        Assert.assertTrue((createdId).equals(validUser.getId()));
    }
    
    @Test
    void updateUserTest(){
        doNothing().when(userService).update(validUser);
        when(userService.getUserById(10L)).thenReturn(validUser);

        validUserDTO.setSurname("Patrick");

        userFacade.updateUser(validUserDTO);
        
        Assert.assertTrue(userService.getUserById(10L).getSurname().equals("Patrick"));
    }
    
    @Test
    void findUserByIdTest(){
        when(beanMappingService.mapTo(validUser, UserDTO.class)).thenReturn(validUserDTO);
        when(userService.getUserById(10L)).thenReturn(validUser);

        UserDTO resUserDTO = userFacade.getUserById(validUser.getId());
        Assert.assertTrue((resUserDTO).equals(validUserDTO));
    }
    
    @Test
    void findUserByNameTest(){
        when(beanMappingService.mapTo(validUser, UserDTO.class)).thenReturn(validUserDTO);
        when(userService.getUserByName("Jean")).thenReturn(validUser);

        UserDTO resUserDTO = userFacade.getUserByName(validUser.getName());
        Assert.assertTrue(resUserDTO.equals(validUserDTO));
    }
    
    @Test
    void findAllUserTest(){
    	List<User> usersList = new ArrayList<>();
    	usersList.add(validUser);
        when(userService.getAllUsers()).thenReturn(usersList);
        
    	List<UserDTO> usersDTOList = new ArrayList<>();
    	usersDTOList.add(validUserDTO);
        when(beanMappingService.mapTo(usersList, UserDTO.class)).thenReturn(usersDTOList);

        List<UserDTO> resListUserDTO = new ArrayList<>(userFacade.getAllUsers());

        verify(userService).getAllUsers();
        Assert.assertTrue((resListUserDTO.size())==1);
        Assert.assertTrue(resListUserDTO.contains(validUserDTO));
    }
    
    @Test
    void isAdminTest(){
    	when(userService.registerUser(validUser,"blabla")).thenReturn(validUser);
        Long createdId = userFacade.createUser(userCreateDTO,"blabla");
        verify(userService).registerUser(validUser, "blabla");    
        
        Assert.assertTrue(userService.isAdmin(validUser));
    }
    
    @Test
    void authenticateTest() {
    	Assert.assertTrue(userFacade.authenticate(userAuthDTO));
    }
}

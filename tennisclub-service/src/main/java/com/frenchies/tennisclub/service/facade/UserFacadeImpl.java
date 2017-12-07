package com.frenchies.tennisclub.service.facade;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.UserFacade;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.UserService;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

@Service
@Transactional
public class UserFacadeImpl implements UserFacade {

	@Inject
	private UserService userService;

	@Autowired
	private BeanMappingService beanMappingService;

	@Override
	public Long createUser(UserCreateDTO userCreatedDTO, String unencryptedPassword) {
		User mappedUser = beanMappingService.mapTo(userCreatedDTO, User.class);
		userService.registerUser(mappedUser, unencryptedPassword);
		return mappedUser.getId();
	}

	@Override
	public void updateUser(UserDTO userDTO) {
		User userToUpdate = new User();
		userToUpdate.setDateOfBirth(userDTO.getDateOfBirth());
		userToUpdate.setMail(userDTO.getMail());
		userToUpdate.setPhone(userDTO.getPhone());
		userToUpdate.setName(userDTO.getName());
		userToUpdate.setSurname(userDTO.getSurname());
		userToUpdate.setId(userDTO.getId());

		userService.update(userToUpdate);
	}

	@Override
	public void deleteUser(Long userId) {
		User userToDelete = userService.getUserById(userId);
		userService.delete(userToDelete);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return beanMappingService.mapTo(users, UserDTO.class);
	}

	@Override
	public UserDTO getUserByName(String name) {
		User user = userService.getUserByName(name);
		if (user == null) {
			return null;
		}
		return beanMappingService.mapTo(user, UserDTO.class);
	}
	
	@Override
	public UserDTO getUserByEmail(String Email) {
		User user = userService.getUserByEmail(Email);
		if (user == null) {
			return null;
		}
		return beanMappingService.mapTo(user, UserDTO.class);
	}

	@Override
	public UserDTO getUserById(Long userId) {
		User user = userService.getUserById(userId);
		if (user == null)
			return null;
		return (user == null) ? null : beanMappingService.mapTo(user, UserDTO.class);
	}

	@Override
	public boolean isAdmin(UserDTO u) {
		return userService.isAdmin(beanMappingService.mapTo(u, User.class));
	}

	@Override
	public boolean isAdmin(Long id) {
		return userService.isAdmin(id);
	}

	@Override
	public boolean authenticate(UserAuthenticateDTO u) {
		return userService.authenticate(userService.getUserById(u.getUserId()), u.getPassword());
	}

	@Override
	public boolean authenticate(UserDTO u, String password) {
		return userService.authenticate(userService.getUserById(u.getId()), password);
	}

	

}
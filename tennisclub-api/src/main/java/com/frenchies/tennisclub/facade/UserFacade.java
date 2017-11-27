package com.frenchies.tennisclub.facade;
import java.util.List;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;

/**
 * 
 * @author Jacquet Valentin 43362
 *
 */

public interface UserFacade {
	
	/**
	 * Method for updating an user
	 * @param userDTO
	 * @return UserDTO
	 */
	
	public UserDTO updateUser(UserDTO user);
	
	/**
	 * Method for creating an user
	 * @param UserCreateDTO, String
	 * @return Long
	 */
	
	
	public Long createUser(UserCreateDTO user, String unHashPassword);
	
	/**
	 * Method for getting the user by its name
	 * @param String
	 * @return UserDTO
	 */
	
	
	public UserDTO getUserByName(String Name);
	
	/**
	 * Method for getting the user by its Id
	 * @param Long userId
	 * @return UserDTO
	 */
	
	
	public UserDTO getUserById(Long userId);
	/**
	 * Method for authenticating an user
	 * @param UserAuthenticateDTO
	 * @return boolean
	 */
	
	
	public boolean authenticate(UserAuthenticateDTO u);
	
	/**
	 * Method for check if the user is an admin or not
	 * @param UserDTO
	 * @return boolean
	 */
	

	public boolean isAdmin(UserDTO u);
	
	/**
	 * Method for getting all users
	 * @param void
	 * @return List<UserDTO>
	 */
	
	
	public List<UserDTO> getAllUsers();
	}

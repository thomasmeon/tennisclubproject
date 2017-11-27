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
	 * Creates a user.
	 *
	 * @param userDTO
	 *            userDTO object to be created as User object
	 * @return user ID
	 */
	public Long createUser(UserCreateDTO user, String unHashPassword);

	/**
	 * Updates a user
	 * 
	 * @param userDTO
	 *            attributes.
	 * @param userDTO
	 *            's attributes will update old User attributes.
	 */
	public void updateUser(UserDTO user);

	/**
	 * Removes a user.
	 *
	 * @param userId
	 *            used to find a User
	 */
	void deleteUser(Long userId);

	/**
	 * Method for getting the user by its name
	 * 
	 * @param String
	 * @return UserDTO
	 */

	public UserDTO getUserByName(String Name);

	/**
	 * Method for getting the user by its Id
	 * 
	 * @param Long
	 *            userId
	 * @return UserDTO
	 */
	public UserDTO getUserById(Long userId);

	/**
	 * Method for authenticating an user
	 * 
	 * @param UserAuthenticateDTO
	 * @return boolean
	 */

	/**
	 * Authenticate the User
	 */
	public boolean authenticate(UserAuthenticateDTO u);

	public boolean authenticate(UserDTO u, String password);

	/**
	 * Check whether {@link User} is admin, or not.
	 *
	 * @param user
	 *            to check or Id
	 * @return true if user is admin, false otherwise
	 */
	public boolean isAdmin(UserDTO u);

	public boolean isAdmin(Long id);

	/**
	 * Method for getting all users
	 * 
	 * @param void
	 * @return List<UserDTO>
	 */

	public List<UserDTO> getAllUsers();
}

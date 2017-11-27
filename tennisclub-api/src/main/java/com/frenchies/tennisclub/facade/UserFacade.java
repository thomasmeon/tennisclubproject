package com.frenchies.tennisclub.facade;
import java.util.List;

import com.frenchies.tennisclub.dto.UserAuthenticateDTO;
import com.frenchies.tennisclub.dto.UserCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface UserFacade {
	
	/**
     * Creates a user.
     *
     * @param userDTO userDTO object to be created as User object
     * @return user ID
     */
	public Long createUser(UserCreateDTO user, String unHashPassword);
	
	/**
     * Updates a user 
     * 
     * @param userDTO attributes.
     * @param userDTO 's attributes will update old User attributes.
     */
	public void updateUser(UserDTO user);
	
	/**
     * Removes a user.
     *
     * @param userId used to find a User
     */
    void deleteUser(Long userId);
    
    /**
	 * Get all {@link User}.
	 *
	 * @return list of users.
	 */
	public List<UserDTO> getAllUsers();
    
    /**
     * Gives User by using	
     * @param Name
     * @return UserDTO
     */
	public UserDTO getUserByName(String Name);
	
	/**
     * Gives User by using	
     * @param Id
     * @return UserDTO
     */
	public UserDTO getUserById(Long userId);
	
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
	
	
}

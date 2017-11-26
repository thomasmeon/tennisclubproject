package com.frenchies.tennisclub.service;

import java.util.List;

import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
public interface UserService {
	/**
	 * Register the given user with the given unencrypted password.
	 * 
	 * Authenticate {@link User}.
	 *
	 * @return true only if hashed unencryptedPassword is equal with user hashed
	 *         password
	 */
	public void registerUser(User u, String unencryptedPassword);

	/**
	 * Get all {@link User}.
	 *
	 * @return list of users.
	 */
	public List<User> getAllUsers();

	/**
	 * Try to authenticate a user. Return true only if the hashed password matches
	 * the records.
	 */
	public boolean authenticate(User u, String password);

	/**
	 * Check whether {@link User} is admin, or not.
	 *
	 * @param user
	 *            to check
	 * @return true if user is admin, false otherwise
	 */
	public boolean isAdmin(User u);

	/**
	 * Delete {@link HumanPlayer}.
	 *
	 * @param humanPlayer
	 *            to delete
	 */
	public void delete(User u);

	/**
	 * Update {@link HumanPlayer}.
	 *
	 * @param humanPlayer
	 *            to update
	 * @return updated human player
	 */
	public User update(User user);

	/**
	 * Find {@link User} by id.
	 *
	 * @param id
	 *            user identifier
	 * @return user with given id
	 */
	public User getUserById(Long userId);

	/**
	 * Find {@link HumanPlayer} by username.
	 *
	 * @param username
	 *            human player's username
	 * @return human player with given username
	 */
	public User getUserByName(String name);
	
	boolean updatePassword(User u, String oldPassword, String newPassword);
}

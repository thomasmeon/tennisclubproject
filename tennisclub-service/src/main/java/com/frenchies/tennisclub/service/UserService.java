package com.frenchies.tennisclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
@Service
public interface UserService {
	/**
	 * Register the given user with the given unencrypted password.
	 */
	public User registerUser(User user, String unencryptedPassword);

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
	 *            to check or id
	 * @return true if user is admin, false otherwise
	 */
	public boolean isAdmin(User u);
	public boolean isAdmin(Long id);

	/**
	 * Delete {@link User}.
	 *
	 * @param humanPlayer
	 *            to delete
	 */
	public void delete(User u);

	/**
	 * Update {@link User}.
	 *
	 * @param humanPlayer
	 *            to update
	 */
	public void update(User user);

	/**
	 * Find {@link User} by id.
	 *
	 * @param id
	 *            user identifier
	 * @return user with given id
	 */
	public User getUserById(Long userId);

	/**
	 * Find {@link User} by username.
	 *
	 * @param username
	 *            user's username
	 * @return User with given username
	 */
	public User getUserByName(String name);
}

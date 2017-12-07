package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.User;

/**
 * DAO interface for entity User
 * @author ValentinJacquet 473362
 *
 */
public interface UserDao {
	/**
	 * Create new User
	 * @param people to add
	 */
	public void create(User u);

	/**
	 * Find an User in DB by using his ID
	 * @param id
	 * @return people find
	 */
	public User findById(Long id);

	/**
	 * Find a people in DB by using his name
	 * @param name
	 * @return user
	 */
	public User findUserByName(String name);
	
	/**
	 * Find a people in DB by using his name
	 * @param name
	 * @return user
	 */
	public User findUserByEmail(String email);
	
	/**
	 * Update a User already in DB
	 * @param people updated
	 */
	User update(User u);
	
	/**
	 * Get all people
	 * @return list of people
	 */
	public List<User> findAll();
	
	/**
	 * Remove a User already in DB
	 * @param people to be remove
	 */
	void remove(User u);
}

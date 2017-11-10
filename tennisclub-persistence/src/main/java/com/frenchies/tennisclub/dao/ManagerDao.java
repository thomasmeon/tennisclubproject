package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Manager;

/**
 * Dao Interface for entity Manager
 * 
 * @author ValentinJacquet 473362
 *
 */
public interface ManagerDao {
	
	/**
	 * Create new Manager
	 * @param people to add
	 */
	public void create(Manager m);

	/**
	 * Find a people in DB by using his ID
	 * @param id
	 * @return people find
	 */
	public Manager findById(Long id);

	/**
	 * Find a people in DB by using his name
	 * @param name
	 * @return
	 */
	public Manager findUserByName(String name);
	
	/**
	 * Update a Manager already in DB
	 * @param people updated
	 */
	void update(Manager m);
	
	/**
	 * Get all people
	 * @return list of people
	 */
	public List<Manager> findAll();
	
	/**
	 * Remove a Manager already in DB
	 * @param people to be remove
	 */
	void remove(Manager m);
}

package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.People;

/**
 * Dao Interface for entity People
 * 
 * @author ValentinJacquet
 *
 */
public interface PeopleDao {
	
	/**
	 * Create new People
	 * @param people to add
	 */
	public void create(People p);

	/**
	 * Find a people in DB by using his ID
	 * @param id
	 * @return people find
	 */
	public People findById(Long id);

	/**
	 * Find a people in DB by using his name
	 * @param Name
	 * @return
	 */
	public People findUserByName(String Name);
	
	/**
	 * Get all people
	 * @return list of people
	 */
	public List<People> findAll();
}

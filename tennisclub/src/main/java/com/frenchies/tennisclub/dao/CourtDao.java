package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Court;

/**
 * DAO interface for entity Court
 * 
 * @author ValentinJacquet
 *
 */
public interface CourtDao {
	
	/**
	 * Create new Tennis Court
	 * @param court to add
	 */
	void create(Court c);
	
	/**
	 * find all court already in DB
	 * @return list of court
	 */
	List<Court> findAll();
	
	/**
	 * Find court by using its id
	 * @param id
	 * @return court
	 */
	Court findById(Long id);
	
	/**
	 * Remove one court
	 * @param court to be removed
	 * @throws IllegalArgumentException
	 */	
	void remove(Court c);
}

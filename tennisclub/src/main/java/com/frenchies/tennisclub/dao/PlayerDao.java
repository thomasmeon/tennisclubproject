package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Player;

/**
 * Dao Interface for entity Player
 * 
 * @author ValentinJacquet 473362
 *
 */
public interface PlayerDao {
	
	/**
	 * Create new Player
	 * @param people to add
	 */
	public void create(Player p);

	/**
	 * Find a people in DB by using his ID
	 * @param id
	 * @return people find
	 */
	public Player findById(Long id);

	/**
	 * Find a people in DB by using his name
	 * @param name
	 * @return
	 */
	public Player findUserByName(String name);
	
	/**
	 * Update a Player already in DB
	 * @param people updated
	 */
	void update(Player b);
	
	/**
	 * Get all people
	 * @return list of people
	 */
	public List<Player> findAll();
	
	/**
	 * Remove a Player already in DB
	 * @param people to be remove
	 */
	void remove(Player b);
}

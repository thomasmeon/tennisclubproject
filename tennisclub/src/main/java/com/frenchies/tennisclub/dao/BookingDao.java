package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Booking;

/**
 * 
 * DAO Interface for entity Booking
 * 
 * @author ValentinJacquet
 *
 */
public interface BookingDao {
	/**
	 * Create new booking
	 * @param booking to add
	 */
	void create(Booking b);
	
	/**
	 * find all booking already made
	 * @return list of booking
	 */
	List<Booking> findAll();
	
	/**
	 * Find user using is Name
	 * @param user's name
	 * @return booking with this user name
	 */
	Booking findUserByName(String name);
	
	/**
	 * Find booking by using the booking number
	 * @param id
	 * @return booking
	 */
	Booking findById(Long id);
	
	/**
	 * Remove one booking
	 * @param booking to be removed
	 * @throws IllegalArgumentException
	 */
	void remove(Booking b)  throws IllegalArgumentException;
}

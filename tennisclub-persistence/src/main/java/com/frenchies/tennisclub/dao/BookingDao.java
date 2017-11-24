package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Booking;

/**
 * 
 * DAO Interface for entity Booking
 * 
 * @author ValentinJacquet 473362
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
	 * Find booking by using the booking number
	 * @param id
	 * @return booking
	 */
	Booking findById(Long id);
	
	/**
	 * Update a booking already in DB
	 * @param booking updated
	 */
	void update(Booking b);
	
	/**
	 * Remove one booking
	 * @param booking to be removed
	 * @throws IllegalArgumentException
	 */
	void remove(Booking b)  throws IllegalArgumentException;
}

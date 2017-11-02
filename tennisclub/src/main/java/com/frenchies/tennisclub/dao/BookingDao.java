package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Booking;

/**
 * 
 * @author ValentinJacquet
 *
 */
public interface BookingDao {
	public void create(Booking b);
	public List<Booking> findAll();
	public Booking findUserByName(String name);
	public Booking findById(Long id);
	public void remove(Booking b)  throws IllegalArgumentException;
}

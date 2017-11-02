package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.People;

/**
 * 
 * @author ValentinJacquet
 *
 */
public interface BookingDao {
	public void create(Booking b);
	public List<Booking> findAll();
	public List<Booking> findByUser(People p);
	public Booking findById(Long id);
	public void remove(Booking b)  throws IllegalArgumentException;
}

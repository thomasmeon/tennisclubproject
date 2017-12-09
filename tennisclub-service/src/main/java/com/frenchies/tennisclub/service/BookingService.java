package com.frenchies.tennisclub.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author Corentin Dore 473308
 *
 */
@Service
public interface BookingService {

	/**
	 * create a booking.
	 */
	public Booking createBooking(Booking booking);
	
	/**
	 * Cancel a Booking already in DB
	 * 
	 * @param Booking
	 */	
	public void deleteBooking(Booking Booking);

	/**
	 * Get all saved bookings belonging to the given user
	 * 
	 * @param user
	 * @return
	 */
	public List<Booking> getBookingsByUser(User user);

	/**
	 * Get all saved bookings.
	 */
	public List<Booking> getAllBookings();

	/**
	 * Find a booking using its id
	 * 
	 * @param id
	 * @return
	 */
	public Booking getBookingById(Long id);
	
	/**
	 * Get all booking of last week
	 * 
	 * @return
	 */
	public List<Booking> getAllBookingsLastWeek();

	List<Booking> getBookingsByCourt(Long idCourt);

}

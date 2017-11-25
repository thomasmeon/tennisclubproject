package com.frenchies.tennisclub.service;

import java.util.List;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
public interface BookingService {
	
	void createBooking(Booking b);
	
	/**
	 * Get all saved bookings belonging to the given user.
	 */
	List<Booking> getBookingsByUser(User user);


	List<Booking> findAllBookings();
	
	void deleteBooking(Booking Booking);

	Booking findBookingById(Long id);

	List<Booking> getAllBookingsLastWeek();
}

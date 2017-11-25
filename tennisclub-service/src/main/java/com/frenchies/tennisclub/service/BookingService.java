package com.frenchies.tennisclub.service;

import java.util.Date;
import java.util.List;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
public interface BookingService {

	/**
	 * create a booking.
	 */
	void createBooking(Booking b);

	/**
	 * Get all saved bookings belonging to the given user
	 * 
	 * @param user
	 * @return
	 */
	List<Booking> getBookingsByUser(User user);

	/**
	 * Get all saved bookings.
	 */
	List<Booking> findAllBookings();

	/**
	 * Cancel a Booking already in DB
	 * 
	 * @param Booking
	 */
	void cancelBooking(Booking Booking);

	/**
	 * Find a booking using its id
	 * 
	 * @param id
	 * @return
	 */
	Booking findBookingById(Long id);

	/**
	 * Get all booking of last week
	 * 
	 * @return
	 */
	List<Booking> getAllBookingsLastWeek();

	/**
	 * Get all booking belonging to the given user in a period between 2 dates
	 * 
	 * @param start
	 * @param end
	 * @param u
	 * @return
	 */
	List<Booking> getAllBookingsByUserBetween(Date start, Date end, User u);

	/**
	 * Get all booking in a period between 2 dates
	 * @param start
	 * @param end
	 * @return
	 */
	List<Booking> getAllBookingsBetween(Date start, Date end);
}

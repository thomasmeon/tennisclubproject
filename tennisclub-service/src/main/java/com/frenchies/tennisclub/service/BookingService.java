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
<<<<<<< HEAD

	/**
	 * Cancel a Booking already in DB
	 * 
	 * @param Booking
	 */
	void cancelBooking(Booking Booking);
=======
	
	void deleteBooking(Booking Booking);
>>>>>>> 59599f98dfc7abf477e7455f793178ea99dfb7e9

	/**
	 * Find a booking using its id
	 * 
	 * @param id
	 * @return
	 */
	Booking findBookingById(Long id);

<<<<<<< HEAD
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
=======
	List<Booking> getAllBookingsLastWeek();
>>>>>>> 59599f98dfc7abf477e7455f793178ea99dfb7e9
}

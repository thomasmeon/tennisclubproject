package com.frenchies.tennisclub.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
@Service
public interface BookingService {

	/**
	 * create a booking.
	 */
	public Booking createBooking(Booking booking);

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
	 * Cancel a Booking already in DB
	 * 
	 * @param Booking
	 */	
	public void deleteBooking(Booking Booking);

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

	/**
	 * Get all booking belonging to the given user in a period between 2 dates
	 * 
	 * @param start
	 * @param end
	 * @param u
	 * @return
	 */
	public List<Booking> getAllBookingsByUserBetween(Date start, Date end, User u);

	/**
	 * Get all booking in a period between 2 dates
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Booking> getAllBookingsBetween(Date start, Date end);

	/**
	 * Get all booking of one date
	 * @param date
	 * @return
	 */
	public List<Booking> getBookingsByDate(Date date);
}

package com.frenchies.tennisclub.facade;

import java.util.Date;
import java.util.List;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.UserDTO;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface BookingFacade {
	
<<<<<<< HEAD
	public List<BookingDTO> getAllBookings();
	public List<BookingDTO> getBookingByUser(UserDTO user);
	public BookingDTO getBookingById(Long bookingId);
//	public List<BookingDTO> findBookingByDate(date date);
	
	
	public Long createBooking(BookingCreateDTO b);
	public void deleteBooking(Long idBooking);
	
}
=======
	
	public BookingDTO findBookingById(Long bookingId);
	public Long createBooking(BookingCreateDTO p);
	public void deleteBooking(Long idBooking);
	
	
	
	public List<BookingDTO> getAllBookings();
	public List<BookingDTO> findBookingsByDate(Date date);
	public List<BookingDTO> getBookingsByUser(UserDTO u);
	public List<BookingDTO> getAllBookingsByUserBetween(Date start, Date end, UserDTO u);
	public List<BookingDTO> getAllBookingsBetween(Date start, Date end);
	public List<BookingDTO> getAllBookingsLastWeek();
	}
>>>>>>> 4859684bca87eff87896a07eff54c2ed2aa53b62

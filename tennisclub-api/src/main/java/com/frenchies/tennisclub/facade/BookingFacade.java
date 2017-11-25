package com.frenchies.tennisclub.facade;

import java.util.Date;
import java.util.List;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.enums.Hour24;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface BookingFacade {
	
	public List<BookingDTO> getAllBookings();
	public List<BookingDTO> getBookingByUser(UserDTO user);
	public BookingDTO getBookingById(Long bookingId);
//	public List<BookingDTO> findBookingByDate(date date);
	
	
	public Long createBooking(BookingCreateDTO b);
	public void deleteBooking(Long idBooking);
	
}

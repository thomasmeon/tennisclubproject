package com.frenchies.tennisclub.facade;

import java.util.Date;
import java.util.List;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.enums.Hour24;

public interface BookingFacade {
	
	public List<BookingDTO> getAllBookings();
	public List<BookingDTO> findBookingByUser(UserDTO user);
	public List<BookingDTO> findBookingById(Long bookingId);
//	public List<BookingDTO> findBookingByDate(date date);
	

	public BookingDTO createBooking(long idBooking, long idCourt, UserDTO user1, UserDTO user2, Date dateOfBooking, Hour24 hourOfBooking);
	
	public void deleteBooking(long idBooking);
}

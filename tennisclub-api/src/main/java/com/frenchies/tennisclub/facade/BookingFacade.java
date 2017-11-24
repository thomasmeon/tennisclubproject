package com.frenchies.tennisclub.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.OrderDTO;

public class BookingFacade {
	
	public List<BookingDTO> getAllBookings();
	public List<BookingDTO> findBookingByUser(User user);
	public List<BookingDTO> findBookingById(Long bookingId);
//	public List<BookingDTO> findBookingByDate(date date);
	

	public Long createBooking(long idBooking, long idCourt, long idPlayer1, long idPlayer2, date dateOfBooking, Hour24 hourOfBooking);
	
	public void deleteBooking(long idBooking);
}

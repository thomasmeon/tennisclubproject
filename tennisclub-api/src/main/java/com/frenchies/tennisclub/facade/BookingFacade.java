package com.frenchies.tennisclub.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Court;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface BookingFacade {

	public BookingDTO getBookingById(Long bookingId);

	public Long createBooking(BookingCreateDTO p);

	public void deleteBooking(Long idBooking);

	public List<BookingDTO> getAllBookings();

	public List<BookingDTO> getBookingsByCourt(Long idCourt);

	public List<BookingDTO> getBookingsByUser(UserDTO u);

	public List<BookingDTO> getAllBookingsLastWeek();
	public List<BookingDTO> getAllBookingsLastMonth();
	public List<BookingDTO> getAllBookingsLastYear();

}

package com.frenchies.tennisclub.service.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.UserService;


/**
 * 
 * @author Meon Thomas 473449
 *
 */

@Service
@Transactional
public class BookingFacadeImpl implements BookingFacade  {
	
	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	@Autowired
	private BeanMappingService beanMappingService;
	
	@Override
	public List<BookingDTO> getAllBookings() {
		return beanMappingService.mapTo(bookingService.findAllBookings(),
				BookingDTO.class);
	}
	
	@Override
	public BookingDTO getBookingById(Long bookingId) {
		return beanMappingService.mapTo(bookingService.findBookingById(bookingId),
				BookingDTO.class);
	}
	
		
	@Override
	public List<BookingDTO> getBookingByUser(UserDTO u) {
		User user = userService.findUserById(u);
		List<Booking> bookings = bookingService.getBookingsByUser(user);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}
	
	@Override
	public List<BookingDTO> getBookingByDate(Date date){
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void deleteBooking(Long bookingId) {
		bookingService.deleteBooking(bookingService.findBookingById(bookingId));
	}
	
	@Override
	public Long createBooking(BookingCreateDTO b) {
		Booking mappedBooking = beanMappingService.mapTo(b, Booking.class);
        
		mappedBooking.setUser1(userService.findUserById(b.getUser1().getId()));
		mappedBooking.setUser2(userService.findUserById(b.getUser2().getId()));
		
		mappedBooking.setDateOfBooking(b.getDateOfBooking());
		mappedBooking.setHourOfBooking(b.getHourOfBooking());
		mappedBooking.setIdCourt(b.getIdCourt());
		
        Booking newBooking = bookingService.createBooking(mappedBooking);
        
		return newBooking.getIdBooking();
	}	

}

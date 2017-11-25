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
public class BookingFacadeImpl implements BookingFacade {

	@Autowired
	private BookingService bookingService;

	@Autowired
	private UserService userService;

	@Autowired
	private BeanMappingService beanMappingService;

	@Override
	public List<BookingDTO> getAllBookings() {
		return beanMappingService.mapTo(bookingService.getAllBookings(), BookingDTO.class);
	}

	@Override
<<<<<<< HEAD
	public BookingDTO getBookingById(Long bookingId) {
		return beanMappingService.mapTo(bookingService.findBookingById(bookingId),
				BookingDTO.class);
=======
	public BookingDTO findBookingById(Long bookingId) {
		return beanMappingService.mapTo(bookingService.findBookingById(bookingId), BookingDTO.class);
>>>>>>> 4859684bca87eff87896a07eff54c2ed2aa53b62
	}

	@Override
<<<<<<< HEAD
	public List<BookingDTO> getBookingByUser(UserDTO u) {
		User user = userService.findUserById(u);
=======
	public List<BookingDTO> getBookingsByUser(UserDTO u) {
		User user = userService.findUserById(u.getId());
>>>>>>> 4859684bca87eff87896a07eff54c2ed2aa53b62
		List<Booking> bookings = bookingService.getBookingsByUser(user);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}

	@Override
<<<<<<< HEAD
	public List<BookingDTO> getBookingByDate(Date date){
        throw new UnsupportedOperationException("Not supported yet.");
=======
	public List<BookingDTO> findBookingsByDate(Date date) {
		final List<Booking> allBookingsByDate = bookingService.findBookingsByDate(date);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsByDate, BookingDTO.class);
		return dtos;
>>>>>>> 4859684bca87eff87896a07eff54c2ed2aa53b62
	}

	@Override
	public void deleteBooking(Long bookingId) {
		bookingService.deleteBooking(bookingService.findBookingById(bookingId));
	}
<<<<<<< HEAD
	
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
=======

	@Override
	public List<BookingDTO> getAllBookingsLastWeek() {
		final List<Booking> allBookingsLastWeek = bookingService.getAllBookingsLastWeek();
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastWeek, BookingDTO.class);
		return dtos;
	}

	@Override
	public List<BookingDTO> getAllBookingsBetween(Date start, Date end) {
		final List<Booking> allBookingsBetween = bookingService.getAllBookingsBetween(start, end);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsBetween, BookingDTO.class);
		return dtos;
	}

	@Override
	public List<BookingDTO> getAllBookingsByUserBetween(Date start, Date end, UserDTO u) {
		User uTemp = new User(u.getId());
		final List<Booking> allBookingsByUserBetween = bookingService.getAllBookingsByUserBetween(start, end, uTemp);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsByUserBetween, BookingDTO.class);
		return dtos;
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
>>>>>>> 4859684bca87eff87896a07eff54c2ed2aa53b62

}

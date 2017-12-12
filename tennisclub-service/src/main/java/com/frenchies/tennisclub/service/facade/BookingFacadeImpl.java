package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.BookingCreateDTO;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.service.BeanMappingService;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.CourtService;
import com.frenchies.tennisclub.service.UserService;
	
/**
 * 
 * @author Jacquet Valentin 473362
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
	private CourtService courtService;

	@Autowired
	private BeanMappingService beanMappingService;

	@Override
	public List<BookingDTO> getAllBookings() {
		return beanMappingService.mapTo(bookingService.getAllBookings(), BookingDTO.class);
	}

	@Override
	public BookingDTO getBookingById(Long bookingId) {
		return beanMappingService.mapTo(bookingService.getBookingById(bookingId), BookingDTO.class);
	}

	@Override
	public List<BookingDTO> getBookingsByUser(UserDTO u) {
		User user = userService.getUserById(u.getId());
		List<Booking> bookings = bookingService.getBookingsByUser(user);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}

	@Override
	public void deleteBooking(Long bookingId) {
		bookingService.deleteBooking(bookingService.getBookingById(bookingId));
	}

	@Override
	public List<BookingDTO> getAllBookingsLastWeek() {
		final List<Booking> allBookingsLastWeek = bookingService.getAllBookingsLastWeek();
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastWeek, BookingDTO.class);
		return dtos;
	}
	
	@Override
	public List<BookingDTO> getAllBookingsLastMonth() {
		final List<Booking> allBookingsLastMonth = bookingService.getAllBookingsLastMonth();
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastMonth, BookingDTO.class);
		return dtos;
	}
	
	@Override
	public List<BookingDTO> getAllBookingsLastYear() {
		final List<Booking> allBookingsLastYear = bookingService.getAllBookingsLastYear();
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastYear, BookingDTO.class);
		return dtos;
	}
	
	@Override
	public List<BookingDTO> getAllBookingsLastWeekByUser(Long idUser) {
		User uTemp = new User();
		uTemp.setId(idUser);
		final List<Booking> allBookingsLastWeek = bookingService.getAllBookingsLastWeekByUser(uTemp);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastWeek, BookingDTO.class);
		return dtos;
	}
	
	@Override
	public List<BookingDTO> getAllBookingsLastMonthByUser(Long idUser) {
		User uTemp = new User();
		uTemp.setId(idUser);
		final List<Booking> allBookingsLastMonth = bookingService.getAllBookingsLastMonthByUser(uTemp);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastMonth, BookingDTO.class);
		return dtos;
	}
	
	@Override
	public List<BookingDTO> getAllBookingsLastYearByUser(Long idUser) {
		User uTemp = new User();
		uTemp.setId(idUser);
		final List<Booking> allBookingsLastYear = bookingService.getAllBookingsLastYearByUser(uTemp);
		final List<BookingDTO> dtos = beanMappingService.mapTo(allBookingsLastYear, BookingDTO.class);
		return dtos;
	}

	@Override
	public List<BookingDTO> getBookingsByCourt(Long idCourt) {
		List<Booking> bookings = bookingService.getBookingsByCourt(idCourt);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}

	@Override
	public Long createBooking(BookingCreateDTO b) {

		Booking mappedBooking = beanMappingService.mapTo(b, Booking.class);

		mappedBooking.setUser1(userService.getUserById(b.getUser1().getId()));
		mappedBooking.setUser2(userService.getUserById(b.getUser2().getId()));

		mappedBooking.setDateOfBooking(b.getDateOfBooking());
		mappedBooking.setHourOfBooking(b.getHourOfBooking());
		mappedBooking.setIdCourt(b.getIdCourt());

		Booking newBooking = bookingService.createBooking(mappedBooking);

		return newBooking.getIdBooking();
	}

}

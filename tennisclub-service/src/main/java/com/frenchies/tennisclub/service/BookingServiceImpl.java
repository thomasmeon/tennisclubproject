package com.frenchies.tennisclub.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao BookingDao;
	@Autowired
	private TimeService timeService;

	@Override
	public void createBooking(Booking Booking) {
        BookingDao.create(Booking);
    }

    public Booking findBookingById(Long id) {
		return BookingDao.findById(id);
	}

	public List<Booking> findAllBookings() {
		return BookingDao.findAll();
	}

	public List<Booking> getBookingsByUser(User user) {
		return BookingDao.findByUser(user);
	}

	public List<Booking> getAllBookingsLastWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeService.getCurrentTime());
		calendar.add(Calendar.DAY_OF_YEAR, -7);
		Date lastWeek = calendar.getTime();
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(lastWeek, timeService.getCurrentTime());
		return Bookings;
	}

	public void cancelBooking(Booking Booking) {
		BookingDao.remove(Booking);
	}

}

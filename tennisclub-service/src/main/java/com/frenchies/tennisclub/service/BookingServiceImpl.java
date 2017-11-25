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

	@Override
    public Booking findBookingById(Long id) {
		return BookingDao.findById(id);
	}

	@Override
	public List<Booking> findAllBookings() {
		return BookingDao.findAll();
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		return BookingDao.findByUser(user);
	}

	@Override
	public List<Booking> getAllBookingsLastWeek() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeService.getCurrentTime());
		calendar.add(Calendar.DAY_OF_YEAR, -7);
		Date lastWeek = calendar.getTime();
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(lastWeek, timeService.getCurrentTime());
		return Bookings;
	}
	
	@Override
	public List<Booking> getAllBookingsBetween(Date start, Date end) {
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(start, end);
		return Bookings;
	}
	
	@Override
	public List<Booking> getAllBookingsByUserBetween(Date start, Date end, User u) {
		List<Booking> Bookings = BookingDao.getBookingsForUserCreatedBetween(start, end, u);
		return Bookings;
	}

	@Override
	public void deleteBooking(Booking Booking) {
		BookingDao.remove(Booking);
	}

}

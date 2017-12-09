package com.frenchies.tennisclub.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.dao.BookingDao;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.Hour24;

/**
 * 
 * @author ValentinJacquet 473362
 *
 */
@Service
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	private BookingDao BookingDao;
	@Autowired
	private TimeService timeService;

	@Override
	public Booking createBooking(Booking booking) throws IllegalArgumentException {
		if (!isValidBooking(booking)) {
            throw new IllegalArgumentException(UserServiceImpl.class +
                    " - Booking argument is not valid.");
        }
        BookingDao.create(booking);
		return booking;
    }
	
	@Override
	public void deleteBooking(Booking booking) throws IllegalArgumentException {
		if (!isValidBooking(booking)) {
            throw new IllegalArgumentException(UserServiceImpl.class +
                    " - Booking argument is not valid.");
        }
		BookingDao.remove(booking);
	}

	@Override
    public Booking getBookingById(Long id) {
		return BookingDao.findById(id);
	}

	@Override
	public List<Booking> getAllBookings() {
		return BookingDao.findAll();
	}

	@Override
	public List<Booking> getBookingsByUser(User user) {
		return BookingDao.findByUser(user);
	}
	
	@Override
	public List<Booking> getBookingsByCourt(Long idCourt) {
		return BookingDao.findByCourt(idCourt);
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
	public List<Booking> getAllBookingsLastMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeService.getCurrentTime());
		calendar.add(Calendar.DAY_OF_YEAR, -30);
		Date lastMonth = calendar.getTime();
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(lastMonth, timeService.getCurrentTime());
		return Bookings;
	}
	
	@Override
	public List<Booking> getAllBookingsLastYear() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(timeService.getCurrentTime());
		calendar.add(Calendar.DAY_OF_YEAR, -365);
		Date lastYear = calendar.getTime();
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(lastYear, timeService.getCurrentTime());
		return Bookings;
	}
	
	@Override
	public List<Booking> getBookingsCreatedBetween(Date start, Date end) {
		List<Booking> Bookings = BookingDao.getBookingsCreatedBetween(start, end);
		return Bookings;
	}
	
	private boolean isValidBooking(Booking booking) {
        if (booking == null) {
            return false;
        }
        User user1 = booking.getUser1();
        if (user1 == null) {
            return false;
        }
        User user2 = booking.getUser2();
        if (user2 == null) {
            return false;
        }
        Long idCourt = booking.getIdCourt();
        if (idCourt == null) {
            return false;
        }
        Hour24 Hour = booking.getHourOfBooking();
        if (Hour == null) {
            return false;
        }
        Date date = booking.getDateOfBooking();
        if (date == null) {
            return false;
        }
        return true;
    }

}

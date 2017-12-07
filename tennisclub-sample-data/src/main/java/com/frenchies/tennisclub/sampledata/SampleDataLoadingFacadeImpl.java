package com.frenchies.tennisclub.sampledata;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

//import com.frenchies.tennisclub.dao.PriceRepository;
//import com.frenchies.tennisclub.dto.Color;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.enums.Hour24;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.CourtService;
import com.frenchies.tennisclub.service.UserService;

/**
 * Loads some sample data to populate the database.
 *
 * @author Meon Thomas 473449
 */

@Component
@Transactional // transactions are handled on facade layer
public class SampleDataLoadingFacadeImpl implements SampleDataLoadingFacade {

	final static Logger log = LoggerFactory.getLogger(SampleDataLoadingFacadeImpl.class);

	public static final String JPEG = "image/jpeg";

	@Autowired
	private UserService userService;
	@Autowired
	private CourtService courtService;
	@Autowired
	private BookingService bookingService;

	@Override
	@SuppressWarnings("unused")
	public void loadData() throws IOException {
		Calendar cal = Calendar.getInstance();
		cal.set(2017,1, 1);
		Date date1 = cal.getTime();
		cal.set(2017, 2, 2);
		Date date2 = cal.getTime();
		cal.set(2017, 3, 2);
		Date date3 = cal.getTime();
		cal.set(2017, 4, 2);
		Date date4 = cal.getTime();
		cal.set(2017, 5, 2);
		Date date5 = cal.getTime();
		cal.set(2017, 6, 2);
		Date date6 = cal.getTime();
		cal.set(2017, 7, 2);
		Date date7 = cal.getTime();
		cal.set(2017, 8, 2);
		Date date8 = cal.getTime();
		cal.set(2017, 9, 2);
		Date date9 = cal.getTime();
		cal.set(2017, 10, 2);
		Date date10 = cal.getTime();
		cal.set(2017, 11, 2);
		Date date11 = cal.getTime();
		cal.set(2017, 2, 3);
		Date date12 = cal.getTime();
		cal.set(2017, 3, 3);
		Date date13 = cal.getTime();
		cal.set(2017, 4, 3);
		Date date14 = cal.getTime();
		cal.set(2017, 5, 3);
		Date date15 = cal.getTime();
		cal.set(2017, 6, 3);
		Date date16 = cal.getTime();
		cal.set(2017, 7, 3);
		Date date17 = cal.getTime();
		cal.set(2017, 8, 3);
		Date date18 = cal.getTime();
		cal.set(2017, 9, 3);
		Date date19 = cal.getTime();
		cal.set(2017, 10, 3);
		Date date20 = cal.getTime();
		cal.set(2017, 11, 3);
		Date date21 = cal.getTime();
		
		Court court1 = court(45l, CourtType.GRASS);
		Court court2 = court(55l, CourtType.CLAY);
		Court court3 = court(65l, CourtType.HARD);
		Court court4 = court(75l, CourtType.GRASS);
		log.info("Loaded court.");
		
		User Jean = user("heslo", 1000l, "Jean", "A", "jean@A.cz", "603123456",date12);
		User Jean2 = user("heslo", 1001l, "Jean2", "A2", "jean2@A.cz", "603123456",date13);
		User Jean3 = user("heslo", 1002l, "Jean3", "A3", "jean3@A.cz", "603123456",date14);
		User Jean4 = user("heslo", 1003l, "Jean4", "A4", "jean4@A.cz", "603123456",date15);
		User Jean5 = user("heslo", 1004l, "Jean5", "A5", "jean5@A.cz", "603123456",date16);
		User admin = user("admin", 1000l, "admin", "Admin", "admin@A.cz", "603123456",date17);
		log.info("Loaded users.");
		
		
		
		Booking b1 = booking(100l, date1, Hour24.EIGHT, Jean, Jean2);
		Booking b2 = booking(101l, date2, Hour24.SEVEN, Jean, Jean3);
		Booking b3 = booking(102l, date3, Hour24.EIGHT, Jean, Jean4);
		Booking b4 = booking(103l, date4, Hour24.EIGHT, Jean, Jean5);
		Booking b5 = booking(104l, date5, Hour24.EIGHT, Jean2, Jean);
		Booking b6 = booking(105l, date6, Hour24.EIGHT, Jean, Jean2);
		Booking b7 = booking(106l, date7, Hour24.EIGHT, Jean, Jean2);
		Booking b8 = booking(107l, date8, Hour24.EIGHT, Jean, Jean2);
		Booking b9 = booking(108l, date9, Hour24.EIGHT, Jean, Jean2);
		log.info("Loaded bookings.");
		
	}
	
	private Booking booking(Long idBooking, Date dateOfBooking, Hour24 hourOfBooking, User user1 , User user2) throws IOException {
		Booking b = new Booking();
		b.setIdBooking(idBooking);
		b.setDateOfBooking(dateOfBooking);
		b.setHourOfBooking(hourOfBooking);
		b.setUser1(user1);
		b.setUser2(user2);
		bookingService.createBooking(b);
		return b;
	}
	
	private Court court(Long idCourt, CourtType type) {
		Court c = new Court();
		c.setIdCourt(idCourt);
		c.setCourtType(type);
		courtService.createCourt(c);
		return c;
	}
	
	private User user(String password, Long idUser, String name, String surname, String email, String phone, Date dateOfBirth) {
		User u = new User();
		u.setId(idUser);
		u.setName(name);
		u.setSurname(surname);
		u.setMail(email);
		u.setPhone(phone);
		u.setDateOfBirth(dateOfBirth);
		if (password.equals("admin"))
			u.setAdmin(true);
		userService.registerUser(u, password);
		return u;
	}
}

//	private static Date daysBeforeNow(int days) {
//		return Date.from(ZonedDateTime.now().minusDays(days).toInstant());
//	}
//
//	private static Date toDate(int year, int month, int day) {
//		return Date.from(LocalDate.of(year, month, day).atStartOfDay(ZoneId.systemDefault()).toInstant());
//	}
//
//	private Order order(User user, Date created, OrderState state, OrderItem... items) {
//		Order o = new Order();
//		o.setUser(user);
//		o.setCreated(created);
//		o.setState(state);
//		for (OrderItem item : items) {
//			o.addOrderItem(item);
//		}
//		orderService.createOrder(o);
//		return o;
//	}
//
//	private OrderItem orderItem(Product product, int amount) {
//		OrderItem oi = new OrderItem();
//		oi.setProduct(product);
//		oi.setPricePerItem(product.getCurrentPrice());
//		oi.setAmount(amount);
//		return oi;
//	}
//
//	
//
//	
//	private static Random random = new Random();
//
//	private Price price(long price, ZonedDateTime priceStart) {
//		Price p = new Price();
//		p.setCurrency(Currency.CZK);
//		p.setPriceStart(Date.from(priceStart.toInstant()));
//		p.setValue(BigDecimal.valueOf(price));
//		return p;
//	}
//
//	
//
//	private byte[] readImage(String file) throws IOException {
//		try (InputStream is = this.getClass().getResourceAsStream("/" + file)) {
//			int nRead;
//			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
//			byte[] data = new byte[1024];
//			while ((nRead = is.read(data, 0, data.length)) != -1) {
//				buffer.write(data, 0, nRead);
//			}
//			buffer.flush();
//			return buffer.toByteArray();
//		}
//	}

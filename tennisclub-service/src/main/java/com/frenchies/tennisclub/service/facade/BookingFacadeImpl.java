package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.date;
import com.frenchies.tennisclub.service.BeanMappingService;
import com.frenchies.tennisclub.service.BookingService;
import com.frenchies.tennisclub.service.UserService;


@Service
@Transactional
public class BookingFacadeImpl {
	
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
	public BookingDTO findBookingById(Long bookingId) {
		return beanMappingService.mapTo(bookingService.findBookingById(bookingId),
				BookingDTO.class);
	}
	
		
	@Override
	public List<BookingDTO> findBookingByUser(User u) {
		User user = userService.findUserById(u);
		List<Booking> bookings = BookingService.getBookingsByUser(user);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}
	
	@Override
	public List<BookingDTO> findBookingByDate(date date){
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
//	@Override
//	public Long createBooking(BookingCreateDTO p) {
//		Booking mappedBooking = beanMappingService.mapTo(p, Booking.class);
//        
//        Price price = new Price();
//        price.setValue(p.getPrice());
//        price.setCurrency(p.getCurrency());
//        Date now = new Date();
//        price.setPriceStart(now);
//        mappedProduct.setAddedDate(now);
//        //set price on product entity
//        mappedProduct.setCurrentPrice(price);
//        mappedProduct.addHistoricalPrice(price);
//        //add to category
//        mappedProduct.addCategory(categoryService.findById(p.getCategoryId()));
//        //save product
//        Product newProduct = productService.createProduct(mappedProduct);
//		return newProduct.getId();
//	}
	
	@Override
	public void deleteBooking(Long bookingId) {
		bookingService.deleteBooking(new Booking(bookingId));
	}
	

	

}

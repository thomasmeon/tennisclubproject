package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;
import com.frenchies.tennisclub.facade.BookingFacade;
import com.frenchies.tennisclub.facade.date;
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
	public BookingDTO findBookingById(long bookingId) {
		return beanMappingService.mapTo(bookingService.findBookingById(bookingId),
				BookingDTO.class);
	}
	
		
	@Override
	public List<BookingDTO> findBookingByUser(User u) {
		User user = userService.findUserById(u);
		List<Booking> bookings = bookingService.getBookingsByUser(user);

		return beanMappingService.mapTo(bookings, BookingDTO.class);
	}
	
	@Override
	public List<BookingDTO> findBookingByDate(date date){
        throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void deleteBooking(Long bookingId) {
		bookingService.deleteBooking(bookingService.findBookingById(bookingId));
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
	
	

	

}

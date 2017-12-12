package com.frenchies.tennisclub.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.service.config.ServiceConfiguration;

/**
 * Tests for BeanMappingService class.
 *
 * @author Dore Corentin 473308
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class BeanMappingServiceTest extends AbstractTestNGSpringContextTests {
	
	@Autowired
    private BeanMappingService beanMappingService;
    
    private List<Booking> bookings = new ArrayList<Booking>();
    
    @BeforeMethod
    public void createOrders(){
		
		Booking b1 = new Booking(1l);
		bookings.add(b1);
		
		Booking b2 = new Booking(2l);
		bookings.add(b2);
		
		Booking b3 = new Booking(3l);
		bookings.add(b3);
		
    }
    
    @Test
    public void shouldMapInnerCategories(){
    	List<BookingDTO> resultList = beanMappingService.mapTo(bookings, BookingDTO.class);
    	Assert.assertEquals(resultList.size(), 3);
    	
    }
}


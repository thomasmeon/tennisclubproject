package com.frenchies.tennisclub.service.config;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.frenchies.tennisclub.PersistenceSampleApplicationContext;
import com.frenchies.tennisclub.dto.BookingDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.dto.UserDTO;
import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.entity.User;

/**
 * 
 * @author Meon Thomas 473449
 *
 */


@Configuration
@Import(PersistenceSampleApplicationContext.class)
@ComponentScan(basePackages="com.frenchies.tennisclub")
public class ServiceConfiguration {
	

	@Bean
	public Mapper dozer(){
		DozerBeanMapper dozer = new DozerBeanMapper();		
		dozer.addMapping(new DozerCustomConfig());
		return dozer;
	}
	
	
	public class DozerCustomConfig extends BeanMappingBuilder {
	    @Override
	    protected void configure() {
	        mapping(Court.class, CourtDTO.class);
	        mapping(Booking.class, BookingDTO.class);
	        mapping(User.class, UserDTO.class);
	    }
	}
	
}


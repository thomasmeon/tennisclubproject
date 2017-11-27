package com.frenchies.tennisclub.service;

import java.util.Date;

import org.springframework.stereotype.Service;

/**
 * An interface that defines a service access to the {@link Product} entity.
 */

//@Author Jacquet Valentin 473362


@Service
public class TimeServiceImpl implements TimeService{

	@Override
	public Date getCurrentTime() {
		return new Date();
	}
	
}

package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.CourtService;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public class CourtFacadeImpl implements CourtFacade {

	@Autowired
	private CourtService courtService;

	@Autowired
	private BeanMappingService beanMappingService;

	@Override
	public List<CourtDTO> getAllCourts() {
		return beanMappingService.mapTo(courtService.findAll(), CourtDTO.class);
	}

}

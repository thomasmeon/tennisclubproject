package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


public class CourtFacadeImpl {
	
	@Autowired
	private CourtService courtService;

	@Autowired
	private BeanMappingService beanMappingService;
	
	
	
	@Override
	   public List<CategoryDTO> getAllCourts()
    {
        return beanMappingService.mapTo(courtService.findAll(),CourtDTO.class);
    }
	

}

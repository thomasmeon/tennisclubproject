package com.frenchies.tennisclub.service.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.dto.CourtCreateDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;
import com.frenchies.tennisclub.facade.CourtFacade;
import com.frenchies.tennisclub.mappers.BeanMappingService;
import com.frenchies.tennisclub.service.CourtService;

/**
 * 
 * @author Meon Thomas 473449
 *
 */
@Service
@Transactional
public class CourtFacadeImpl implements CourtFacade {

	@Autowired
	private CourtService courtService;

	@Autowired
	private BeanMappingService beanMappingService;

	@Override
	public List<CourtDTO> getAllCourts() {
		return beanMappingService.mapTo(courtService.getAllCourts(), CourtDTO.class);
	}
	
	@Override
	public CourtDTO getCourtById(Long courtId) {
		return beanMappingService.mapTo(courtService.getCourtById(courtId), CourtDTO.class);
	}
	
	@Override
	public void deleteCourt(Long courtId) {
		courtService.deleteCourt(courtService.getCourtById(courtId));
	}
	
	@Override
	public void changeCourtType(Long courtId, CourtType newCourtType) {
		courtService.changeCourtType(courtService.getCourtById(courtId), newCourtType);
	}
	
	@Override
	public Long createCourt(CourtCreateDTO c) {

		Court mappedCourt = beanMappingService.mapTo(c, Court.class);
		
		mappedCourt.setIdCourt(c.getIdCourt());
		mappedCourt.setStatus(c.getStatus());
		mappedCourt.setCourtType(c.getCourtType());
		mappedCourt.setLatitude(c.getLatitude());
		mappedCourt.setLongitude(c.getLongitude());
		
		Court newCourt = courtService.createCourt(mappedCourt);

		return newCourt.getIdCourt();
	}

}

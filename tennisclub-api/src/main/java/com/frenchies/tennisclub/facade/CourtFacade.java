package com.frenchies.tennisclub.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.CourtCreateDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.enums.CourtType;

/**
 * 
 * @author Meon Thomas 473449
 *
 */

public interface CourtFacade {
	
	List<CourtDTO> getAllCourts();
	public Long createCourt(CourtCreateDTO c);
	public CourtDTO getCourtById(Long id);
	public void deleteCourt(Long id);
	public void changeCourtType(Long id, CourtType newCourtType);
	
}

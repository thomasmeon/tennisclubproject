package com.frenchies.tennisclub.facade;

import java.util.List;

import com.frenchies.tennisclub.dto.CourtCreateDTO;
import com.frenchies.tennisclub.dto.CourtDTO;
import com.frenchies.tennisclub.enums.CourtType;

/**
 * 
 * @author Dore Corentin 473308
 *
 */

public interface CourtFacade {
	
	/**
	 * Method for getting all courts
	 * @param 
	 * @return List<CourtDTO>
	 */
	List<CourtDTO> getAllCourts();
	
	/**
	 * Method for creating a court
	 * @param CourtCreateDTO
	 * @return Long
	 */
	public Long createCourt(CourtCreateDTO c);
	
	/**
	 * Method for getting a court by its id
	 * @param Long
	 * @return CourtDTO
	 */
	public CourtDTO getCourtById(Long id);
	
	/**
	 * Method for deleting a court
	 * @param Long
	 * @return 
	 */
	public void deleteCourt(Long id);
	
	/**
	 * Method for changing the type of the court
	 * @param Long, CourtType
	 * @return
	 */
	public void changeCourtType(Long id, CourtType newCourtType);
	
}

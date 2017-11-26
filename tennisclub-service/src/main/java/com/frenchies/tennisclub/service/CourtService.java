package com.frenchies.tennisclub.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;

/**
 * 
 * @author valentinjacquet 4733362
 *
 */
@Service
public interface CourtService {
	/**
	 * Creation of a new court
	 * @param court
	 * @return
	 */
	public Court createCourt(Court c);
	
	/**
	 * Find court with an id
	 * @param id
	 * @return court
	 */
	public Court findById(Long id);
	
	/**
	 * Find all courts of the club
	 * @return list of courts
	 */
	public List<Court> findAll();
	
	/**
	 * Delete one court
	 * @param court
	 */
	public void deleteCourt(Court c);
	
	/**
	 * Change the type of the court
	 * @param c
	 * @param newCourtType
	 */
	public void changeCourtType(Court c, CourtType newCourtType);
}

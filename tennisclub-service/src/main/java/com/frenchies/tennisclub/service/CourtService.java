package com.frenchies.tennisclub.service;

import java.util.List;

import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;

/**
 * 
 * @author valentinjacquet 4733362
 *
 */

public interface CourtService {
	public Court findById(Long id);
	public List<Court> findAll();
	public Court createCourt(Court c);
	public void deleteCourt(Court c);
	public void changeCourtType(Court c, CourtType newCourtType);
}

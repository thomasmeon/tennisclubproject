package com.frenchies.tennisclub.service;

import java.util.List;

import javax.inject.Inject;

import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;

public class CourtServiceImpl implements CourtService {
	
	@Inject
	private CourtDao courtDao;

	@Override
	public Court getCourtById(Long id) {
		return courtDao.findById(id);
	}

	@Override
	public List<Court> getAllCourts() {
		return courtDao.findAll();
	}

	@Override
	public Court createCourt(Court c) {
		courtDao.create(c);
		return c;
	}

	@Override
	public void deleteCourt(Court c) {
		courtDao.remove(c);
		
	}

	@Override
	public void changeCourtType(Court c, CourtType newCourtType) {
		Court cTemp = getCourtById(c.getIdCourt());
		if (cTemp != null) {
			cTemp.setCourtType(newCourtType);
			courtDao.update(cTemp);
		}
		else {
			throw new IllegalArgumentException("Cannot search for null court");
		}
			
	}

}

package com.frenchies.tennisclub.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.frenchies.tennisclub.dao.CourtDao;
import com.frenchies.tennisclub.entity.Court;
import com.frenchies.tennisclub.enums.CourtType;

//@Author Meon Thomas UCO 473449


@Service
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

		Court court = courtDao.findById(c.getIdCourt());
		court.setType(newCourtType);
		courtDao.update(court);
	}

}

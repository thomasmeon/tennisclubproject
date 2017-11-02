package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.Court;

public interface CourtDao {
	void create(Court c);
	List<Court> findAll();
	Court findById(Long id);
	void remove(Court c);
}

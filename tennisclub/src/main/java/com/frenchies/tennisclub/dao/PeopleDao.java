package com.frenchies.tennisclub.dao;

import java.util.List;

import com.frenchies.tennisclub.entity.People;

/**
 * 
 * @author ValentinJacquet
 *
 */
public interface PeopleDao {
	public void create(People p);
	 public People findById(Long id);
	 public People findUserByName(String Name);
	 public  List<People> findAll();
}

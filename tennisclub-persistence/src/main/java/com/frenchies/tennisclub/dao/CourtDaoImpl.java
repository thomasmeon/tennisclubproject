package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.Court;

/**
 * Implementation of CourtDao
 * 
 * @author ValentinJacquet 473362
 *
 */
@Repository
public class CourtDaoImpl implements CourtDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Court c) {
		em.persist(c);
	}

	@Override
	public List<Court> findAll() {
		return em.createQuery("select c from Court c", Court.class).getResultList();
	}

	@Override
	public Court findById(Long id) {
		return em.find(Court.class, id);
	}

	@Override
	public void remove(Court c) {
		em.remove(c);
	}

	@Override
	public void update(Court c) {
		em.merge(c);		
	}

}

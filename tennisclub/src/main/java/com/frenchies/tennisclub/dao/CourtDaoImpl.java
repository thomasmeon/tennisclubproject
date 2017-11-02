package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.Court;

@Repository
public class CourtDaoImpl implements CourtDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Court c) {
		em.persist(c);
	}

	public List<Court> findAll() {
		return em.createQuery("select c from Court c", Court.class).getResultList();
	}

	public Court findById(Long id) {
		try {
			return em.createQuery("select c from Court c where id = :id", Court.class).setParameter(":id", id)
					.getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	public void remove(Court c) {
		em.remove(c);
	}

}

package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.People;

/**
 * 
 * @author ValentinJacquet
 *
 */
@Repository
public class PeopleDaoImpl implements PeopleDao {

	@PersistenceContext
	private EntityManager em;

	public void create(People p) {
		em.persist(p);
	}

	public People findById(Long id) {
		try {
			return em.createQuery("select p from People p where id = :id", People.class).setParameter(":id", id)
					.getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	public People findUserByName(String name) {
		try {
			return em.createQuery("select p from People p where name = :name", People.class).setParameter(":name", name)
					.getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	public List<People> findAll() {
		return em.createQuery("select p from People p", People.class).getResultList();
	}

}

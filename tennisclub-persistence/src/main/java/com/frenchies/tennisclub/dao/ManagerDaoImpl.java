package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.Manager;

/**
 * Implementation of ManagerDao
 * 
 * @author ValentinJacquet 473362
 *
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Manager m) {
		em.persist(m);
	}

	@Override
	public Manager findById(Long id) {
		return em.find(Manager.class, id);
	}

	@Override
	public Manager findUserByName(String name) {
		return em.find(Manager.class, name);
	}

	@Override
	public List<Manager> findAll() {
		return em.createQuery("select m from Manager m", Manager.class).getResultList();
	}

	@Override
	public void update(Manager m) {
		em.merge(m);
	}

	@Override
	public void remove(Manager m) {
		em.remove(m);
	}

}

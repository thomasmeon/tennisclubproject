package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.entity.Booking;

/**
 * Implementation of Booking Dao
 * @author ValentinJacquet 473362
 *
 */
@Repository
@Transactional
public class BookingDaoImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Booking b) {
		if (b == null)
            throw new IllegalArgumentException("Booking cannot be null");
		em.persist(b);
	}

	@Override
	public List<Booking> findAll() {
		return em.createQuery("select b from Booking b", Booking.class).getResultList();
	}

	@Override
	public Booking findById(Long id) {
		try {
			return em.createQuery("select b from Booking b where id = :id", Booking.class).setParameter(":id", id)
					.getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	@Override
	public void remove(Booking b) throws IllegalArgumentException {
		em.remove(b);
	}

	@Override
	public void update(Booking b) {
		em.merge(b);		
	}

}

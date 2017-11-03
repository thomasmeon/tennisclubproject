package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.Booking;

/**
 * 
 * @author ValentinJacquet
 *
 */
@Repository
public class BookingDaoImpl implements BookingDao {

	@PersistenceContext
	private EntityManager em;

	public void create(Booking b) {
		em.persist(b);
	}

	public List<Booking> findAll() {
		return em.createQuery("select b from Booking b", Booking.class).getResultList();
	}

	public Booking findUserByName(String name) {
		try {
			return em.createQuery("select b from Booking b where name = :name", Booking.class)
					.setParameter(":name", name).getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	public Booking findById(Long id) {
		try {
			return em.createQuery("select b from Booking b where id = :id", Booking.class).setParameter(":id", id)
					.getSingleResult();
		} catch (NoResultException nrf) {
			return null;
		}
	}

	public void remove(Booking b) throws IllegalArgumentException {
		em.remove(b);
	}

}

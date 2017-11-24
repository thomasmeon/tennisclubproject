package com.frenchies.tennisclub.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.frenchies.tennisclub.entity.Booking;
import com.frenchies.tennisclub.entity.User;

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
		return em.find(Booking.class, id);
	}

	@Override
	public void remove(Booking b) throws IllegalArgumentException {
		em.remove(b);
	}

	@Override
	public void update(Booking b) {
		em.merge(b);		
	}

	@Override
	public List<Booking> findByUser(User u) {
		TypedQuery<Booking> query = em.createQuery(
				"Select b from Booking o where b.user = :userid",
				Booking.class);
		
		query.setParameter("userid", u);
		return query.getResultList();
	}
	
	@Override
	public List<Booking> getBookingsCreatedBetween(Date start, Date end) {
		TypedQuery<Booking> query = em
				.createQuery(
						"SELECT o FROM Order o WHERE o.state = :state AND  o.created BETWEEN :startDate AND :endDate ",
						Booking.class);
		query.setParameter("startDate", start);
		query.setParameter("endDate", end);
		return query.getResultList();
	}

}

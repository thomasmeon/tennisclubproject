package com.frenchies.tennisclub.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.frenchies.tennisclub.entity.Player;

/**
 * Implementation of PlayerDao
 * 
 * @author ValentinJacquet 473362
 *
 */
@Repository
public class PlayerDaoImpl implements PlayerDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void create(Player p) {
		em.persist(p);
	}

	@Override
	public Player findById(Long id) {
		return em.find(Player.class, id);
	}

	@Override
	public Player findUserByName(String name) {
		return em.find(Player.class, name);
	}

	@Override
	public List<Player> findAll() {
		return em.createQuery("select p from Player p", Player.class).getResultList();
	}

	@Override
	public void update(Player p) {
		em.merge(p);
	}

	@Override
	public void remove(Player p) {
		em.remove(p);
	}

}

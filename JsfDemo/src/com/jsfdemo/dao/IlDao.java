package com.jsfdemo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsfdemo.model.Il;

@Stateless
public class IlDao {

	@PersistenceContext(unitName = "demo")
	private EntityManager em;

	public void persist(Il il) {
		em.persist(il);
	}

	public List<Il> findAll() {
		return em.createQuery("Select il From il il", Il.class).getResultList();
	}

}

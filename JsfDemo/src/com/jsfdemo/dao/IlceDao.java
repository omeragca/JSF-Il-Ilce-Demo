package com.jsfdemo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.jsfdemo.model.Ilce;

@Stateless
public class IlceDao {

	@PersistenceContext(unitName = "demo")
	private EntityManager em;

	public void persist(Ilce ilce) {
		em.persist(ilce);
	}

	public List<Ilce> findAll() {
		return em.createQuery("Select ilce From ilce ilce", Ilce.class).getResultList();
	}

}

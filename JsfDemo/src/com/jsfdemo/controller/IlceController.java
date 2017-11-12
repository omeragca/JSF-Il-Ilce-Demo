package com.jsfdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jsfdemo.dao.IlceDao;
import com.jsfdemo.model.Ilce;

@ManagedBean(name = "ilceController")
@ViewScoped
public class IlceController {

	private Ilce ilce;
	private List<Ilce> ilceler;

	@EJB
	private IlceDao ilceDao;

	@PostConstruct
	private void init() {
		ilce = new Ilce();
		ilceler = ilceDao.findAll();
	}
	
	public void kaydet() {
		ilceDao.persist(ilce);
		init();
	}
	
	public Ilce getIlce() {
		return ilce;
	}
	
	public void setIlce(Ilce ilce) {
		this.ilce = ilce;
	}

	public List<Ilce> getIlceler() {
		return ilceler;
	}

	public void setIlceler(List<Ilce> ilceler) {
		this.ilceler = ilceler;
	}

}

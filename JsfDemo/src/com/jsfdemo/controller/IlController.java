package com.jsfdemo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.jsfdemo.dao.IlDao;
import com.jsfdemo.model.Il;

@ManagedBean(name = "ilController")
@ViewScoped
public class IlController {

	private Il il;
	private List<Il> iller;

	@EJB
	private IlDao ilDao;

	@PostConstruct
	private void init() {
		il = new Il();
		iller = ilDao.findAll();
	}

	public void kaydet() {
		ilDao.persist(il);
		init();
	}

	public Il getIl() {
		return il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

	public List<Il> getIller() {
		return iller;
	}

	public void setIller(List<Il> iller) {
		this.iller = iller;
	}

}

package com.jsfdemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity(name = "ilce")
@Table(name = "ilce", uniqueConstraints = { @UniqueConstraint(columnNames = { "adi" }) })
public class Ilce {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ilce")
	@SequenceGenerator(name = "seq_ilce", sequenceName = "seq_ilce", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "adi", unique = true)
	private String adi;

	@JoinColumn(name = "il_id")
	@ManyToOne
	private Il il;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdi() {
		return adi;
	}

	public void setAdi(String adi) {
		this.adi = adi;
	}

	public Il getIl() {
		return il;
	}

	public void setIl(Il il) {
		this.il = il;
	}

}

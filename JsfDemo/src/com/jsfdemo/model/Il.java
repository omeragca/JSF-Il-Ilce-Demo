package com.jsfdemo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity(name = "il")
@Table(name = "il", uniqueConstraints = { @UniqueConstraint(columnNames = { "adi" }) })
public class Il {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_il")
	@SequenceGenerator(name = "seq_il", sequenceName = "seq_il", allocationSize = 1)
	@Column(name = "id")
	private Long id;

	@NotNull
	@Column(name = "adi", unique = true)
	private String adi;

	@OneToMany(mappedBy = "il", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Ilce> ilceler;

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

	public List<Ilce> getIlceler() {
		return ilceler;
	}

	public void setIlceler(List<Ilce> ilceler) {
		this.ilceler = ilceler;
	}

}

package com.application.modul3.city;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.application.modul3.citizen.Citizen;

@Entity
@Table(name = "city", schema = "administration")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "city", cascade = { CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.REMOVE }, orphanRemoval = true)
	private List<Citizen> citizens;

	public List<Citizen> getCitizen() {
		return citizens;
	}

	public void setCitizen(List<Citizen> citizen) {
		this.citizens = citizen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addCitizen(Citizen citizen) {
		this.citizens.add(citizen);
		citizen.setCity(this);
	}

	public void removeCitizen(Citizen citizen) {
		this.citizens.remove(citizen);	
		citizen.setCity(null);
	}

}

package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
public class Categorie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String labelle;
	
	@OneToMany(targetEntity = Appareil.class, mappedBy = "categorie", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JsonIgnoreProperties("categorie")
	List<Appareil> appareils;
	
	
	public List<Appareil> getAppareils() {	
		return appareils;
	}
	public void setAppareils(List<Appareil> appareils) {
		this.appareils = appareils;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLabelle() {
		return labelle;
	}
	public void setLabelle(String labelle) {
		this.labelle = labelle;
	}
	
	
}

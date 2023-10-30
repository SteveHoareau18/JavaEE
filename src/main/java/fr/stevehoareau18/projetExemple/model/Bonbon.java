package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Bonbon implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom;
	private Float indiceGlycerique, prix, calorie;
	
	
	
	public Bonbon() {
		super();
	}
	
	@Override
	public String toString() {
		return "Bonbon [nom=" + nom + ", indiceGlycerique=" + indiceGlycerique + ", prix=" + prix + ", calorie="
				+ calorie + "]";
	}
	
	public String getNom() {
		return nom;
	}
	
	public Bonbon setNom(String nom) {
		this.nom = nom;
		return this;
	}
	
	public Float getIndiceGlycerique() {
		return indiceGlycerique;
	}
	
	public Bonbon setIndiceGlycerique(Float indiceGlycerique) {
		this.indiceGlycerique = indiceGlycerique;
		return this;
	}
	
	public Float getPrix() {
		return prix;
	}
	
	public Bonbon setPrix(Float prix) {
		this.prix = prix;
		return this;
	}
	
	public Float getCalorie() {
		return calorie;
	}
	
	public Bonbon setCalorie(Float calorie) {
		this.calorie = calorie;
		return this;
	}

	public long getId() {
		return id;
	}
}

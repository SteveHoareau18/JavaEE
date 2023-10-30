package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Consommateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float id;
	
	private String nom, prenom;
	private LocalDate dateNaissance;
	private Adresse adresse;
	private List<Bonbon> bonbons;
	
	public Consommateur() {
		super();
		this.setBonbons(new ArrayList<Bonbon>());
	}

	@Override
	public String toString() {
		return "Consommateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance
				+ ", adresse=" + adresse + ", bonbons=" + bonbons + "]";
	}

	public String getNom() {
		return nom;
	}


	public Consommateur setNom(String nom) {
		this.nom = nom;
		return this;
	}


	public String getPrenom() {
		return prenom;
	}


	public Consommateur setPrenom(String prenom) {
		this.prenom = prenom;
		return this;
	}


	public LocalDate getDateNaissance() {
		return dateNaissance;
	}


	public Consommateur setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
		return this;
	}


	public List<Bonbon> getBonbons() {
		return bonbons;
	}


	public Consommateur setBonbons(List<Bonbon> bonbons) {
		this.bonbons = bonbons;
		return this;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public Consommateur setAdresse(Adresse adresse) {
		this.adresse = adresse;
		return this;
	}
}

package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Consommateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private float id;
	
	private String nom, prenom;
	private Date dateNaissance;
	@ManyToOne
	private Adresse adresse;
	@OneToMany
	private Set<Bonbon> bonbons;
	
	public Consommateur() {
		super();
		this.setBonbons(new HashSet<Bonbon>());
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


	public Date getDateNaissance() {
		return dateNaissance;
	}


	public Consommateur setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
		return this;
	}


	public Set<Bonbon> getBonbons() {
		return bonbons;
	}


	public Consommateur setBonbons(Set<Bonbon> bonbons) {
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

package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Consommateur implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nom, prenom;
	private Date dateNaissance;
	@ManyToOne
	private Adresse adresse;
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Bonbon> bonbons;
	
	public Consommateur() {
		super();
		this.bonbons = new HashSet<>();
	}

	public long getId() {
		return id;
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
	
	public Consommateur addBonbon(Bonbon bonbon) {
		this.bonbons.add(bonbon);
		return this;
	}
	
	public Consommateur remBonbon(Bonbon bonbon) {
		if(this.bonbons.contains(bonbon))this.bonbons.remove(bonbon);
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

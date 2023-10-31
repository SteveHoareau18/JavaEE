package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

@Entity
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String ville, nomRue;
	private int numeroRue, codePostal;
	@OneToMany
	private Set<Consommateur> residants;
	
	public Adresse() {
		super();
		this.setResidants(new HashSet<Consommateur>());
	}
	
	@Override
	public String toString() {
		return "Adresse [id=" + id + ", ville=" + ville + ", nomRue=" + nomRue + ", numeroRue=" + numeroRue
				+ ", codePostal=" + codePostal + ", residants=" + residants + "]";
	}

	public long getId() {
		return id;
	}

	public String getVille() {
		return ville;
	}
	
	public Adresse setVille(String ville) {
		this.ville = ville;
		return this;
	}
	
	public String getNomRue() {
		return nomRue;
	}
	
	public Adresse setNomRue(String nomRue) {
		this.nomRue = nomRue;
		return this;
	}
	
	public int getNumeroRue() {
		return numeroRue;
	}
	
	public Adresse setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
		return this;
	}
	
	public int getCodePostal() {
		return codePostal;
	}
	
	public Adresse setCodePostal(int codePostal) {
		this.codePostal = codePostal;
		return this;
	}

	public Set<Consommateur> getResidants() {
		return residants;
	}

	public Adresse setResidants(Set<Consommateur> residants) {
		this.residants = residants;
		return this;
	}
}

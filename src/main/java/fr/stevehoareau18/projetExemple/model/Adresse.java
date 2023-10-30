package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Adresse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String ville, nomRue;
	private int numeroRue, codePostal;
	private List<Consommateur> residants;
	
	public Adresse() {
		super();
		this.setResidants(new ArrayList<Consommateur>());
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

	public List<Consommateur> getResidants() {
		return residants;
	}

	public Adresse setResidants(List<Consommateur> residants) {
		this.residants = residants;
		return this;
	}
}

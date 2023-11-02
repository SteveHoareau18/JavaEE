package fr.stevehoareau18.projetExemple.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Utilisateur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String username,password,salt;

	public String getUsername() {
		return username;
	}

	public Utilisateur setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public Utilisateur setPassword(String password) {
		this.password = password;
		return this;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", password=" + password + "]";
	}

	public String getSalt() {
		return salt;
	}

	public Utilisateur setSalt(String salt) {
		this.salt = salt;
		return this;
	}

}

package com.dogmanager.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_utilisateur")
	private int id;
	@Column(name = "nom_utilisateur")
	private String nom;
	@Column(name = "prenom_utilisateur")
	private String prenom;
	private String login;
	private String password;
	private static int idConnected;

	public void setId(int id) {
		Utilisateur.idConnected = id;
	}

	public static int getId() {
		return Utilisateur.idConnected;
	}

	public Utilisateur(String nom_utilisateur, String prenom_utilisateur, String login, String password) {
		super();
		this.nom = nom_utilisateur;
		this.prenom = prenom_utilisateur;
		this.login = login;
		this.password = password;
	}
}
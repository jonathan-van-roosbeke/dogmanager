package com.dogmanager.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur implements Serializable {
	private static final long serialVersionUID = 1L;

	private static int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;

	public static void setId(int id) {
		Utilisateur.id = id;
	}

	public static int getId() {
		return Utilisateur.id;
	}
}
package com.dogmanager.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Utilisateur {
	private static int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;

	public static int getId() {
		return Utilisateur.id;
	}

	public void setId(int id) {
		Utilisateur.id = id;
	}
}
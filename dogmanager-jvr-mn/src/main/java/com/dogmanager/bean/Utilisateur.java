package com.dogmanager.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Utilisateur {
	private int id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private List<Chien> chien;
}
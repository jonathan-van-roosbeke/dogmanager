package com.dogmanager.service;

import javax.servlet.http.HttpServletRequest;

import com.dogmanager.bean.Utilisateur;

public interface IUtilisateurService {

	Utilisateur connexion(HttpServletRequest request);

	public Utilisateur inscription(HttpServletRequest request);

}

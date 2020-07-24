package com.dogmanager.service;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dto.RetourService;

public interface IUtilisateurService {

	public int getCurentUtilisateurId();

	public Utilisateur connexion(String login, String password);

	public RetourService<Utilisateur> inscription(Utilisateur utilisateur);

//	public Utilisateur selectUtilisateurtById(int id);

	public int deleteByLogin(String login);

}

package com.dogmanager.service;

import com.dogmanager.bean.Utilisateur;

public interface IUtilisateurService {

	public Utilisateur connexion(String login, String password);

	public boolean inscription(Utilisateur utilisateur);

	public Utilisateur selectUtilisateurtById(int id);

	public int deleteByLogin(String login);

}

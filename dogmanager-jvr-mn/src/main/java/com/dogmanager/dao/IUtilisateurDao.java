package com.dogmanager.dao;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dto.RetourService;

public interface IUtilisateurDao {

	public Utilisateur connexion(String login, String password);

	public RetourService<Utilisateur> inscription(Utilisateur utilisateur);

	public int deleteByLogin(String login);

}

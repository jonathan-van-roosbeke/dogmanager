package com.dogmanager.dao;

import com.dogmanager.bean.Utilisateur;

/**
 * 
 * @author Mohamed
 *
 */
public interface IUtilisateurDao {

	public Utilisateur connexion(String login, String password);

	public Utilisateur inscription(Utilisateur utilisateur);

	public Utilisateur findByLogin(String login);

	public void deleteByLogin(String login);

}

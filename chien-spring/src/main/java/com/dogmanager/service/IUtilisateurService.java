package com.dogmanager.service;

import com.dogmanager.bean.Utilisateur;

public interface IUtilisateurService {
	/**
	 * 
	 * @return int
	 */

	/**
	 * 
	 * @param login
	 * @param password
	 * @return Utilisateur
	 */
	public Utilisateur connexion(String login, String password);

	/**
	 * 
	 * @param utilisateur
	 * @return RetourService la classe RetourService indique si l'inscripton s'est
	 *         bien passée ou non elle contient un bollean (reussi ou non ) un
	 *         Utilisateur et un message
	 */
	public Utilisateur inscription(Utilisateur utilisateur);

	/**
	 * afin d'eviter de passer chaque teste avec un utilisateur différent cette
	 * methode sert a supprimer l'utilisateur creer pour des teste d'inscription et
	 * connexion utilisateur
	 * 
	 * @param login
	 * @return int
	 * 
	 */
	public void deleteByLogin(String login);

}

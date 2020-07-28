package com.dogmanager.service;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dto.RetourService;

public interface IUtilisateurService {
	/**
	 * 
	 * @return int
	 */

	public int getCurentUtilisateurId();

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
	public RetourService<Utilisateur> inscription(Utilisateur utilisateur);

	/**
	 * afin d'eviter de passer chaque teste avec un utilisateur différent cette
	 * methode sert a supprimer l'utilisateur creer pour des teste d'inscription et
	 * connexion utilisateur
	 * 
	 * @param login
	 * @return int
	 * 
	 */
	public int deleteByLogin(String login);

}

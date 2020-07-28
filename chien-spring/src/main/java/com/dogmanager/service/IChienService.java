package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Chien;

/**
 * IChienService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IChienService {

	/**
	 * 
	 * Methode servant à update le chien en base de donnée en passant par
	 * l’interface IchienDao
	 * 
	 * @param chien
	 * @param idPuce
	 * @param nomChien
	 * @param ageChien
	 * @param idCouleur
	 * @param idRace
	 * @return RetourService<Chien>
	 */
	public Chien update(Chien chien, Chien newChien);

	/**
	 * 
	 * Methode servant à récupéré les chiens de l’utilisateur en base de donnée en
	 * passant par l’interface IchienDao
	 * 
	 * @return List<Chien>
	 */

	public List<Chien> getChiens();

	/**
	 * Methode servant à récupérer un chien par identifiant puce en base de donnée
	 * en passant par l’interface IchienDao
	 * 
	 * @param id
	 * @return Chien
	 */

	public Chien getChienById(int id);

	/**
	 * Methode servant à récupérer les chiens de l'utilisateur par identifiant
	 * utilisateur base de donnée en passant par l’interface IchienDao
	 * 
	 * @param id
	 * @return List<Chien>
	 */

	public List<Chien> getChiensByUtilisateurId(int id);

	/**
	 * Methode servant à ajouter un chien en base de donnée en passant par
	 * l’interface IchienDao
	 * 
	 * @param idPuce
	 * @param nomChien
	 * @param ageChien
	 * @param idCouleur
	 * @param idRace
	 * @return RetourService
	 */
	public Chien ajouterChien(Chien chien);

	/**
	 * Methode servant à supprimer un chien par identifiant puce en base de donnée
	 * en passant par l’interface IchienDao
	 * 
	 * @param idPuce
	 */
	public void deleteChienById(int idPuce);

}

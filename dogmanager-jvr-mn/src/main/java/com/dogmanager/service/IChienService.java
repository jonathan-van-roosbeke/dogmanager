package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Chien;
import com.dogmanager.dto.RetourService;

/**
 * IChienService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IChienService {

	/**
	 * 
	 * Methode servant à update le chien en base de donnée en
	 * passant par l’interface IchienDao
	 * 
	 * @param chien
	 * @param idPuce
	 * @param nomChien
	 * @param ageChien
	 * @param idCouleur
	 * @param idRace
	 * @return RetourService<Chien>
	 */
	public RetourService<Chien> update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur,
			int idRace);

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
	 * @param id
	 * @return RetourService<Chien>
	 */
	public RetourService<Chien> ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	/**
	 * Methode servant à supprimer un chien par identifiant puce en base de donnée
	 * en passant par l’interface IchienDao
	 * 
	 * @param idPuce
	 */
	public void deleteChienById(int idPuce);

}

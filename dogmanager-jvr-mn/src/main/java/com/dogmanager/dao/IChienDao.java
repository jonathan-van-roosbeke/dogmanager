package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;
import com.dogmanager.dto.RetourService;

/**
 * IChienDao.java
 * Interface qui à les methodes suivante : 
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IChienDao {
	/**
	 * 
	 * Retourne RetourService<T> 
	 * 
	 * @param chien
	 * @param idPuce
	 * @param nomChien
	 * @param ageChien
	 * @param idCouleur
	 * @param idRace
	 * @return
	 */
	public RetourService<Chien> update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	/**
	 * 
	 * @return
	 */
	public List<Chien> getChiens();

	/**
	 * 
	 * @param id
	 * @return
	 */
	public List<Chien> getChiensByUtilisateurId(int id);

	/**
	 * 
	 * @param idPuce
	 * @param nomChien
	 * @param ageChien
	 * @param idCouleur
	 * @param idRace
	 * @return
	 */
	public RetourService<Chien> ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	/**
	 * 
	 * @param idPuce
	 */
	public void deleteChienById(int idPuce);

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Chien getChienById(int id);
}

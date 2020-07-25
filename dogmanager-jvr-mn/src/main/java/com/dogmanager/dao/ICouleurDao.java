package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Couleur;

/**
 * ICouleurDao.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface ICouleurDao {

	/**
	 * 
	 * Methode servant à récupérer une couleur par id couleur en base de donnée
	 * 
	 * @param id
	 * @return Couleur
	 */
	public Couleur getCouleurById(int id);

	/**
	 * Methode servant à récupérer la liste de couleur contenu en base de donnée
	 * @return List<Couleur>
	 */
	
	public List<Couleur> getCouleurs();

}

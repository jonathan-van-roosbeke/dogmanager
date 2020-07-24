package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Couleur;

/**
 * ICouleurService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface ICouleurService {

	/**
	 * 
	 * Methode servant à récupérer une couleur par id couleur en base de donnée en
	 * passant par l’interface ICouleurDao
	 * 
	 * @param id
	 * @return Couleur
	 */

	public List<Couleur> getCouleurs();

	/**
	 * Methode servant à récupérer la liste de couleur contenu en base de donnée en
	 * passant par l’interface ICouleurDao
	 * 
	 * @return List<Couleur>
	 */

	public Couleur getCouleurById(int id);

}

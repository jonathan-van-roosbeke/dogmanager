package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Race;

/**
 * IRaceService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IRaceService {

	/**
	 * Methode servant à récupérer une race de chien par id puce en base de donnée
	 * en passant par l'interface IRaceDao
	 * 
	 * @return Race
	 */

	public List<Race> getRaces();

	/**
	 * Methode servant à récupérer la liste de race en base de donnée en passant par
	 * l'interface IRaceDao
	 * 
	 * @param id
	 * @return List<Race>
	 */
	public Race getRaceById(int id);
}
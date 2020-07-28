package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Race;

/**
 * IRaceDao.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IRaceDao {
	/**
	 * Methode servant à récupérer une race de chien par id puce en base de donnée
	 * 
	 * @param id
	 * @return Race
	 */
	public Race getRaceById(int id);

	/**
	 * Methode servant à récupérer la liste de race en base de donnée
	 * @return List<Race>
	 */
	public List<Race> getRaces();

}

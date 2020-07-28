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

	Couleur findById(Integer id);

	void delete(Couleur couleurToDelete) throws Exception;

	List<Couleur> findAll();

	Couleur save(Couleur Couleur) throws Exception;

}

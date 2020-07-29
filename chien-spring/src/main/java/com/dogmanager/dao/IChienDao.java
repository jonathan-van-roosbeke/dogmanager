package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;

/**
 * IChienDao.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IChienDao {

	Chien findById(Integer id);

	void delete(Chien chienToDelete) throws Exception;

	List<Chien> findAll();

	Chien save(Chien chien) throws Exception;

	Chien update(Chien chien, Chien newChien) throws Exception;

	public List<Chien> getChiensByUtilisateurId(int id);

	public List<Chien> findAllPagination(int idUtilisateur, int pageNumber);

	public long getNombreDeChien(int idUtilisateur);

}

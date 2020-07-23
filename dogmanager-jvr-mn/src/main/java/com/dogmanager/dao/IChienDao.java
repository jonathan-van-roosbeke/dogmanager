package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienDao {
	
	public List<Chien> getChiens();
	
	public List<Chien> getChiensByUtilisateurId(int id);
	
	public void ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace, int idUtilisateur);
	
	public void deleteChienById(int idPuce);
}

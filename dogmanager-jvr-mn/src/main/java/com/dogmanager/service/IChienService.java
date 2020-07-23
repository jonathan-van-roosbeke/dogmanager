package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienService {
	
	public List<Chien> getChiens();
	
	public List<Chien> getChiensByUtilisateurId(int id);
	
	public void ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace, int idUtilisateur);
	
	public void deleteChienById(int idPuce);

}

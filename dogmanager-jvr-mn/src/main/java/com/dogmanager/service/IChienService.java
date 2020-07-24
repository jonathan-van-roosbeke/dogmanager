package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienService {
//	public RetourService<Chien> update(Chien chien, HttpServletRequest request);
	public void update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	public List<Chien> getChiens();

	public Chien getChienById(int id);

	public List<Chien> getChiensByUtilisateurId(int id);

	public void ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	public void deleteChienById(int idPuce);

}

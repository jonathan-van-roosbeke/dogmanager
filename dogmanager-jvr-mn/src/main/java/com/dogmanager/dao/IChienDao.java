package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienDao {
	public void update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	public List<Chien> getChiens();

	public List<Chien> getChiensByUtilisateurId(int id);

	public void ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace);

	public void deleteChienById(int idPuce);

	public Chien getChienById(int id);
}

package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienDao {
	public Chien update(Chien chien, Chien newChien);

	public List<Chien> getChiens();

	public List<Chien> getChiensByUtilisateurId(int id);
}

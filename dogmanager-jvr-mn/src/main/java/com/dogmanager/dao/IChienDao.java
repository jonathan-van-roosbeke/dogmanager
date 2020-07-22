package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienDao {
	
	public List<Chien> getChiens();
	
	public List<Chien> getChiensByUtilisateurId(int id);
}

package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Chien;

public interface IChienService {
	
	public List<Chien> getChiens();
	
	public List<Chien> getChiensByUtilisateurId(int id);

}

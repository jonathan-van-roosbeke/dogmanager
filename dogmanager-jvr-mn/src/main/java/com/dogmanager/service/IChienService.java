package com.dogmanager.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dogmanager.bean.Chien;

public interface IChienService {
	public Chien update(Chien chien, HttpServletRequest request);

	public List<Chien> getChiens();

	public List<Chien> getChiensByUtilisateurId(int id);

}

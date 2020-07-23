package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Couleur;

public interface ICouleurService {
	public List<Couleur> getCouleurs();

	public Couleur getCouleurById(int id);

}

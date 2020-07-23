package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Couleur;

public interface ICouleurDao {

	public Couleur getCouleurById(int id);

	public List<Couleur> getCouleurs();

}

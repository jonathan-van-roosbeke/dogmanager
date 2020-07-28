package com.dogmanager.dao.impl;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Couleur;
import com.dogmanager.dao.ICouleurDao;

@Repository
public class CouleurDaoImpl extends GenericDao<Couleur, Integer> implements ICouleurDao {
	public CouleurDaoImpl() {
		super(Couleur.class);
	}
}

package com.dogmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Couleur;
import com.dogmanager.dao.ICouleurDao;
import com.dogmanager.service.ICouleurService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class CouleurServiceImpl implements ICouleurService {

	@Autowired
	ICouleurDao couleurDao;

	@Override
	public List<Couleur> getCouleurs() {
		return couleurDao.getCouleurs();
	}

	@Override
	public Couleur getCouleurById(int id) {
		return couleurDao.getCouleurById(id);
	}
}

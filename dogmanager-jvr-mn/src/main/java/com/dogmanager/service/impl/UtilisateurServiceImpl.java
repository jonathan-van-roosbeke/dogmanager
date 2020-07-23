package com.dogmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.service.IUtilisateurService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	IUtilisateurDao utilisateurDao;

	@Override
	public Utilisateur connexion(String login, String password) {

		return utilisateurDao.connexion(login, password);
	}

	@Override
	public boolean inscription(Utilisateur utilisateur) {

		return utilisateurDao.inscription(utilisateur);
	}

	@Override
	public Utilisateur selectUtilisateurtById(int id) {

		return utilisateurDao.selectUtilisateurtById(id);
	}

	@Override
	public int deleteByLogin(String login) {
		return utilisateurDao.deleteByLogin(login);
	}
}
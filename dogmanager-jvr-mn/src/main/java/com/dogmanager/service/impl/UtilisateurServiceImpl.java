package com.dogmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.dto.RetourService;
import com.dogmanager.service.IUtilisateurService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {

	@Autowired
	IUtilisateurDao utilisateurDao;

	@Override
	public Utilisateur connexion(String login, String password) {

		return utilisateurDao.connexion(login, password);
	}

	@Override
	public RetourService<Utilisateur> inscription(Utilisateur utilisateur) {
		return utilisateurDao.inscription(utilisateur);
	}

	@Override
	public int deleteByLogin(String login) {
		return utilisateurDao.deleteByLogin(login);
	}

	@Override
	public int getCurentUtilisateurId() {
		return Utilisateur.getId();
	}
}
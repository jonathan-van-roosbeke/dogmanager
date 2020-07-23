package com.dogmanager.service.impl;

import javax.servlet.http.HttpServletRequest;

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
	public Utilisateur connexion(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		return utilisateurDao.connexion(login, password);
	}

	@Override
	public boolean inscription(HttpServletRequest request) {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		if (nom != null && prenom != null && login != null && password != null) {
			return utilisateurDao.inscription(new Utilisateur(nom, prenom, login, password)) != 0;
		}
		return false;
	}
}

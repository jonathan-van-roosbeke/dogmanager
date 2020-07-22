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
	public Utilisateur inscription(HttpServletRequest request) {
		return null;
	}
}

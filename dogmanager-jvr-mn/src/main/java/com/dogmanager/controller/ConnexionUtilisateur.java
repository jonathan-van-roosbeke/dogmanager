package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.impl.UtilisateurServiceImpl;

@WebServlet("/login")
public class ConnexionUtilisateur extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	UtilisateurServiceImpl userServiceImp;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur utilisateur = userServiceImp.connexion(request);
		if (utilisateur != null) {
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("liste-utilisateur");
		} else {
			request.setAttribute("erreur", "Utilisateur / mot de  passe incorrect");
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		}
	}
}
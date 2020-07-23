package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IUtilisateurService;

@WebServlet("/login")
public class ConnexionUtilisateur extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IUtilisateurService userServiceImp;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur utilisateur = userServiceImp.connexion(login, password);
		if (utilisateur != null) {
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("liste-utilisateur");
		} else {
			request.setAttribute("erreur", "Utilisateur / mot de  passe incorrect");
			request.getRequestDispatcher("/jsp/index.jsp").forward(request, response);
		}
	}
}
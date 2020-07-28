package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IUtilisateurService;

@WebServlet("/login")
public class ConnexionUtilisateur extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	/*
	 * injection de interfaces IUtilisateurService afin de pouvoir appeler la
	 * methode connexion
	 */
	@Autowired
	IUtilisateurService userServiceImp;

	SessionFactory sessionFactory;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
	}

	/**
	 * si le login ou password est incorrect la methode envoie un message a la jsp
	 * si non, la methode ajoute un utilisateur dans la session et la redirige vers
	 * la servlet liste-utilisateur
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		Utilisateur utilisateur = userServiceImp.connexion(login, password);
		if (utilisateur != null) {
			// ajouter l'utilisateur a la saisson si la connexion est ok
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("liste-utilisateur");
		} else {
			request.setAttribute("erreur", "Utilisateur / mot de  passe incorrect");
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		}
	}
}
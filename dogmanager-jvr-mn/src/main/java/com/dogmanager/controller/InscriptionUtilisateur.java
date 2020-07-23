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

@WebServlet("/inscription")
public class InscriptionUtilisateur extends AbstractServletController {
	private static final long serialVersionUID = 1L;
	@Autowired
	IUtilisateurService userServiceImp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		// TODO check all data
		if (nom != null && prenom != null && login != null && password != null) {
			if (userServiceImp.inscription(new Utilisateur(nom, prenom, login, password))) {
				response.sendRedirect("login");
			} else {
				request.setAttribute("error", "");
				request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
			}
		}
	}
}

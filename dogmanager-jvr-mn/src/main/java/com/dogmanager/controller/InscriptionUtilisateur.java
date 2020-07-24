package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.dto.RetourService;
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
		String nom = request.getParameter("nom") + "";
		String prenom = request.getParameter("prenom") + "";
		String login = request.getParameter("login") + "";
		String password = request.getParameter("password") + "";

		if (nom.matches("[a-zA-Z]{3,}") && prenom.matches("[a-zA-Z]{3,}") && login.length() > 3
				&& password.length() > 5) {
			RetourService<Utilisateur> resultat = userServiceImp
					.inscription(new Utilisateur(nom, prenom, login, password));
			if (resultat.isReussi()) {
				response.sendRedirect("login");
			} else {
				request.setAttribute("erreur", resultat.getMsg());
			}
		}
		request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
	}

	public static void main(String[] args) {
		System.out.println("de".matches("[a-zA-Z]{3,}"));
	}
}
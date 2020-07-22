package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inscription")
public class InscriptionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//
//		Utilisateur utilisateur = UtilisateurServiceImpl.inscription(request);
//		if (utilisateur != null) {
//			response.sendRedirect("");
//		} else {
//			request.setAttribute("error", "Unknown user, please try again");
//			request.getRequestDispatcher("/html/login.html").forward(request, response);
//		}
	}
}

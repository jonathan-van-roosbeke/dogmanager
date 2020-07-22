package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.service.impl.UtilisateurServiceImpl;

@WebServlet("/login")
public class ConnexionUtilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/html/index.html").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		System.out.println(login + " " + password);
		Utilisateur utilisateur = UtilisateurServiceImpl.connexion(login, password);
		if (utilisateur != null) {
			request.getSession().setAttribute("utilisateur", utilisateur);
			response.sendRedirect("list-utilisateur");
		} else {
			request.setAttribute("error", "Unknown user, please try again");
			request.getRequestDispatcher("/html/login.html").forward(request, response);
		}
	}

}
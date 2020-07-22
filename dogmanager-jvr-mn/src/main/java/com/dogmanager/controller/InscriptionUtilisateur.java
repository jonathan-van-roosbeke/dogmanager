package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.impl.UtilisateurServiceImpl;

@WebServlet("/inscription")
public class InscriptionUtilisateur extends AbstractServletController {
	private static final long serialVersionUID = 1L;
	@Autowired
	UtilisateurServiceImpl userServiceImp;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (userServiceImp.inscription(request)) {
			response.sendRedirect("login");
		} else {
			request.setAttribute("error", "");
			request.getRequestDispatcher("/jsp/creer-utilisateur.jsp").forward(request, response);
		}
	}
}

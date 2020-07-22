package com.dogmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Chien;
import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IChienService;

@WebServlet("/liste-utilisateur")
public class ListeChienUtilisateurServlet extends AbstractServletController {

	@Autowired
	private IChienService chienService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			List<Chien> chiens = chienService
					.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
			request.setAttribute("chiens", chiens);
			this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	}

}

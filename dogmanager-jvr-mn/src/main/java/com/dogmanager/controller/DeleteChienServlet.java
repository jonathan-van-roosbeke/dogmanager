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
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IChienService;
import com.dogmanager.service.IUtilisateurService;

@WebServlet("/delete")
public class DeleteChienServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IChienService chienService;
	@Autowired
	IUtilisateurService utilisateurService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("coucou");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			int idPuceChien = Integer.parseInt(request.getParameter("id"));
			chienService.deleteChienById(idPuceChien);
			List<Chien> chiens = chienService.getChiensByUtilisateurId(utilisateurService.getCurentUtilisateurId());
			request.setAttribute("chiens", chiens);
			request.getRequestDispatcher("/liste-utilisateur").forward(request, response);
		}
	}
}

package com.dogmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Chien;
import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IChienService;
import com.dogmanager.service.impl.CouleurServiceImpl;
import com.dogmanager.service.impl.RaceServiceImpl;

@WebServlet("/ajouter-chien")
public class AjoutChienServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	RaceServiceImpl raceService;

	@Autowired
	CouleurServiceImpl couleurService;
	
	@Autowired
	IChienService chienService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			request.setAttribute("races", raceService.getRaces());
			request.setAttribute("couleurs", couleurService.getCouleurs());
			request.getRequestDispatcher("/jsp/ajouter-chien.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPuceChien = Integer.parseInt(request.getParameter("numero-puce"));
		int idRace = Integer.parseInt(request.getParameter("race"));
		String nomChien = request.getParameter("nom-chien");
		int idCouleur = Integer.parseInt(request.getParameter("couleur"));
		int ageChien = Integer.parseInt(request.getParameter("numero-puce"));
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			chienService.ajouterChien(idPuceChien, nomChien, ageChien, idCouleur, idRace, ((Utilisateur) session.getAttribute("utilisateur")).getId());
			List<Chien> chiens = chienService
					.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
			request.setAttribute("chiens", chiens);
			this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request, response);
		}
	}
}

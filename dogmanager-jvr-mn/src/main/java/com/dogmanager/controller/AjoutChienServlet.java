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
import com.dogmanager.dto.RetourService;
import com.dogmanager.service.IChienService;
import com.dogmanager.service.ICouleurService;
import com.dogmanager.service.IRaceService;
import com.dogmanager.service.IUtilisateurService;


@WebServlet("/ajouter-chien")
public class AjoutChienServlet extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	IRaceService raceService;

	@Autowired
	ICouleurService couleurService;

	@Autowired
	IChienService chienService;

	@Autowired
	IUtilisateurService utilisateurService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			request.setAttribute("races", raceService.getRaces());
			request.setAttribute("couleurs", couleurService.getCouleurs());
			request.getRequestDispatcher("/jsp/ajouter-chien.jsp").forward(request, response);
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPuceChien = Integer.parseInt(
				(request.getParameter("numero-puce") + "").matches("[\\d]+") ? request.getParameter("numero-puce")
						: "0");
		int idRace = Integer
				.parseInt((request.getParameter("race") + "").matches("[\\d]+") ? request.getParameter("race") : "0");
		String nomChien = request.getParameter("nom-chien");
		int idCouleur = Integer.parseInt(
				(request.getParameter("couleur") + "").matches("[\\d]+") ? request.getParameter("couleur") : "1");
		int ageChien = Integer
				.parseInt((request.getParameter("age") + "").matches("[\\d]+") ? request.getParameter("age") : "1");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (idRace != 0 && ageChien > 0 && ageChien < 31) {
				RetourService<Chien> rsc = chienService.ajouterChien(idPuceChien, nomChien, ageChien, idCouleur,
						idRace);
				List<Chien> chiens = chienService.getChiensByUtilisateurId(utilisateurService.getCurentUtilisateurId());
				if (rsc.isReussi()) {
					request.setAttribute("chiens", chiens);
					this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request,
							response);
				} else {
					request.setAttribute("erreur", rsc.getMsg());
				}
			}
			request.getRequestDispatcher("/jsp/ajouter-chien.jsp").forward(request, response);
		}
	}
}
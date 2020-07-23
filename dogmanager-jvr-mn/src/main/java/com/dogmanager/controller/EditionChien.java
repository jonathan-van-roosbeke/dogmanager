package com.dogmanager.controller;

import java.io.IOException;

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
import com.dogmanager.service.ICouleurService;
import com.dogmanager.service.IRaceService;

@WebServlet("/EditionChien")
public class EditionChien extends AbstractServletController {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Autowired
	IRaceService raceService;

	@Autowired
	ICouleurService couleurService;

	@Autowired
	private IChienService chienService;

	private int idChien;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			request.setAttribute("races", raceService.getRaces());
			request.setAttribute("couleurs", couleurService.getCouleurs());
			request.getRequestDispatcher("/jsp/editer-chien.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);

		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			String nomChien = request.getParameter("nom-chien");
			int idPuceChien = Integer.parseInt(request.getParameter("numero-puce"));
			int race = Integer.parseInt(request.getParameter("race"));
			int couleur = Integer.parseInt(request.getParameter("couleur"));
			int ageChien = Integer.parseInt(request.getParameter("age"));
			// TODO check all

			Chien newChien = new Chien(idPuceChien, nomChien, ageChien, couleurService.getCouleurById(couleur),
					raceService.getRaceById(race), ((Utilisateur) session.getAttribute("utilisateur")));
			System.out.println(chienService.getChiensById(idChien).getNomChien());
			Chien chiens = chienService.update(chienService.getChiensById(idChien), newChien);
			this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request, response);
		}
	}
}

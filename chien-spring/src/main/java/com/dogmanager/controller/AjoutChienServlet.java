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
import com.dogmanager.bean.Couleur;
import com.dogmanager.bean.Race;
import com.dogmanager.bean.Utilisateur;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IChienService;
import com.dogmanager.service.ICouleurService;
import com.dogmanager.service.IRaceService;
import com.dogmanager.service.IUtilisateurService;

/**
 * IRaceService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

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

	/**
	 * 
	 * GET
	 * 
	 * Si la session de l'utilisateur est null alors on le redirige vers la page de
	 * login pour se connecter. Si la session de l'utilisateur est active alors on
	 * récupère les races et couleur en base de donnée pour l'envoyer pour l'envoyer
	 * à la jsp
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			request.setAttribute("races", raceService.getRaces());
			request.setAttribute("couleurs", couleurService.getCouleurs());
			request.getRequestDispatcher("/WEB-INF/jsp/ajouter-chien.jsp").forward(request, response);
		}
	}

	/**
	 * 
	 * POST
	 * 
	 * On récupère les paramètres de la requete pour vérifier si elle sont valide Si
	 * les paramètres ne sont pas valide alors on actualise la page pour à nouveau
	 * entrer les paramètres du chiens Si les paramètres sont valide alors on envoie
	 * la requete à l'implémentation de l'interface IChienService On ajoute à la
	 * requete la nouvelle liste des chiens puis on redirige l'utilisateur sur la
	 * liste de chien utlisateur
	 */

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idPuceChien = Integer.parseInt(
				(request.getParameter("numero-puce") + "").matches("[\\d]+") ? request.getParameter("numero-puce")
						: "0");
		int idRace = Integer
				.parseInt((request.getParameter("race") + "").matches("[\\d]+") ? request.getParameter("race") : "0");
		String nomChien = (request.getParameter("nom-chien" + "").matches("[\\w]+") ? request.getParameter("nom-chien")
				: "");
		int idCouleur = Integer.parseInt(
				(request.getParameter("couleur") + "").matches("[\\d]+") ? request.getParameter("couleur") : "0");
		int ageChien = Integer
				.parseInt((request.getParameter("age") + "").matches("[\\d]+") ? request.getParameter("age") : "0");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (idRace > 0 && ageChien > 0 && ageChien < 31 && nomChien.length() > 3 && idPuceChien > 0) {
				Couleur couleur = couleurService.getCouleurById(idCouleur);
				Race race = raceService.getRaceById(idRace);
				Utilisateur utilisateur = ((Utilisateur) session.getAttribute("utilisateur"));
				Chien newChien = new Chien(idPuceChien, nomChien, ageChien, utilisateur.getId(), idRace, idCouleur);

				if (couleur != null && race != null) {
					Chien rsc = chienService.ajouterChien(newChien);
					if (rsc != null) {
						rsc.setCouleur(couleurService.getCouleurById(idCouleur));
						rsc.setRace(raceService.getRaceById(idRace));
						List<Chien> chiens = chienService
								.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
						response.sendRedirect("liste-utilisateur");
						return;
					} else {
						request.setAttribute("erreur", "erreur");
					}
				}
			}
			doGet(request, response);
		}
	}
}
package com.dogmanager.controller;

import java.io.IOException;

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

/**
 * IRaceService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

@WebServlet("/EditionChien")
public class EditionChien extends AbstractServletController {
	private static final long serialVersionUID = 1L;
	private HttpSession session;

	@Autowired
	private IRaceService raceService;

	@Autowired
	private ICouleurService couleurService;

	@Autowired
	private IChienService chienService;

	private String idChien;

	/**
	 * 
	 * GET
	 * 
	 * Si la session de l'utilisateur est null alors on le redirige vers la page de
	 * login pour se connecter. Si la session de l'utilisateur est active alors on
	 * récupère les races et couleur en base de donnée pour l'envoyer à la jsp et
	 * montrer l'update
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Chien chien;
		session = request.getSession(false);
		idChien = request.getParameter("id-chien");
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		if (session == null || utilisateur == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (idChien != null && idChien.matches("[0-9]+")) {
				chien = chienService.getChienByPuceId(Integer.parseInt(idChien), utilisateur.getId());
				request.setAttribute("chien", chien);
				request.setAttribute("races", raceService.getRaces());
				request.setAttribute("couleurs", couleurService.getCouleurs());
				request.getRequestDispatcher("/WEB-INF/jsp/editer-chien.jsp").forward(request, response);
				return;
			} else {
				response.sendRedirect("liste-utilisateur");
			}
		}
	}

	/**
	 * 
	 * POST
	 * 
	 * On récupère les paramètres de la requete pour vérifier si elle sont valide Si
	 * les paramètres ne sont pas valide alors on actualise la page pour à nouveau
	 * entrer les paramètres du chiens. Si les paramètres sont valide alors on
	 * envoie la requete à l'implémentation de l'interface IChienService On ajoute à
	 * la requete la nouvelle liste des chiens puis on redirige l'utilisateur sur la
	 * liste de chien utlisateur
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			int idPuceChien = Integer.parseInt(
					(request.getParameter("numero-puce") + "").matches("[\\d]+") ? request.getParameter("numero-puce")
							: "0");
			int idRace = Integer.parseInt(
					(request.getParameter("race") + "").matches("[\\d]+") ? request.getParameter("race") : "0");
			String nomChien = (request.getParameter("nom-chien" + "").matches("[\\w]+")
					? request.getParameter("nom-chien")
					: "");
			int idCouleur = Integer.parseInt(
					(request.getParameter("couleur") + "").matches("[\\d]+") ? request.getParameter("couleur") : "0");
			int ageChien = Integer
					.parseInt((request.getParameter("age") + "").matches("[\\d]+") ? request.getParameter("age") : "0");

			if (idRace > 0 && ageChien > 0 && ageChien < 31 && nomChien.length() > 3 && idPuceChien > 0) {
				Couleur couleur = couleurService.getCouleurById(idCouleur);
				Race race = raceService.getRaceById(idRace);
				Utilisateur utilisateur = ((Utilisateur) session.getAttribute("utilisateur"));
				Chien oldChien = null;
				Chien newChien = new Chien(idPuceChien, nomChien, ageChien, utilisateur.getId(), idCouleur, idRace);
				idChien = request.getParameter("old-puce-chien");
				if (idChien != null && idChien.matches("[0-9]+")) {
					oldChien = chienService.getChienByPuceId(Integer.parseInt(idChien), utilisateur.getId());
				}
				if (oldChien != null && newChien != null) {
					Chien retourServiceChien = chienService.update(oldChien, newChien);
					if (retourServiceChien != null) {
						retourServiceChien.setCouleur(couleurService.getCouleurById(idCouleur));
						retourServiceChien.setRace(raceService.getRaceById(idRace));
						response.sendRedirect("liste-utilisateur");
						return;
					} else {
						request.setAttribute("erreur", "erreur ");
						request.setAttribute("chien", oldChien);
						request.setAttribute("races", raceService.getRaces());
						request.setAttribute("couleurs", couleurService.getCouleurs());
						request.getRequestDispatcher("/WEB-INF/jsp/editer-chien.jsp").forward(request, response);
						return;
					}
				}
			}
			doGet(request, response);
		}
	}
}

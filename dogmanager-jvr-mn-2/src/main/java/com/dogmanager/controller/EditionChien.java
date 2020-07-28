package com.dogmanager.controller;

import java.io.IOException;

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
	private Chien chien;

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
		session = request.getSession(false);
		idChien = request.getParameter("id-chien");
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (idChien != null && idChien.matches("[0-9]+")) {
				chien = chienService.getChienById(Integer.parseInt(idChien));
				request.setAttribute("chien", chien);
				request.setAttribute("races", raceService.getRaces());
				request.setAttribute("couleurs", couleurService.getCouleurs());
				request.getRequestDispatcher("/WEB-INF/jsp/editer-chien.jsp").forward(request, response);
			} else {
				this.getServletContext().getRequestDispatcher("/liste-utilisateur").forward(request, response);
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
		session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			if (idChien != null && idChien.matches("[0-9]+")) {
				String nomChien = request.getParameter("nom-chien");
				int idPuceChien = Integer.parseInt(request.getParameter("numero-puce"));
				int race = Integer.parseInt(request.getParameter("race"));
				int couleur = Integer.parseInt(request.getParameter("couleur"));
				int ageChien = Integer.parseInt(request.getParameter("age"));
				// TODO check all
				Chien chien = chienService.getChienById(Integer.parseInt(idChien));
				if (chien != null) {
					RetourService<Chien> retourServiceChien = chienService.update(chien, idPuceChien, nomChien,
							ageChien, couleur, race);

					if (retourServiceChien.isReussi()) {
						request.getRequestDispatcher("/liste-utilisateur").forward(request, response);
					} else {
						request.setAttribute("erreur", retourServiceChien.getMsg());
					}
				}
			}
			request.getRequestDispatcher("/WEB-INF/jsp/editer-chien.jsp").forward(request, response);
		}
	}
}
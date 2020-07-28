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
import com.dogmanager.service.ICouleurService;
import com.dogmanager.service.IRaceService;
import com.dogmanager.service.IUtilisateurService;

@WebServlet("/liste-utilisateur")
public class ListeChienUtilisateurServlet extends AbstractServletController {

	@Autowired
	IRaceService raceService;

	@Autowired
	ICouleurService couleurService;

	@Autowired
	IChienService chienService;

	@Autowired
	IUtilisateurService utilisateurService;
	private static final long serialVersionUID = 1L;

	private HttpSession session;
	private List<Chien> chiens;

	/**
	 * 
	 * GET
	 * 
	 * Si la session de l'utilisateur est null alors on le redirige vers la page de
	 * login pour se connecter. Si la session de l'utilisateur est active alors on
	 * récupère les chiens de l'utilisateur actuel pour ensuite le rediriger sur sa
	 * page
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			chiens = chienService.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
			request.setAttribute("chiens", chiens);
			request.setAttribute("race", raceService);
			request.setAttribute("couleurs", couleurService.getCouleurs());
			this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/liste-utilisateur.jsp").forward(request,
					response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

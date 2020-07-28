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
import com.dogmanager.service.IUtilisateurService;

/**
 * IRaceService.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

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

	/**
	 * 
	 * POST
	 * 
	 * Si la session de l'utilisateur est null alors on le redirige vers la page de
	 * login pour se connecter. Si la session est active et que les données sont
	 * correcte on utlisie l'implémentation de IChien service pour supprimer les
	 * chien en base de donnée et redirigé l'utilisateur sur la liste de chien
	 * utilisateur
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			int idPuceChien = Integer.parseInt(request.getParameter("id"));
			chienService.deleteChienById(idPuceChien);
			List<Chien> chiens = chienService
					.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
			request.setAttribute("chiens", chiens);
			request.getRequestDispatcher("/liste-utilisateur").forward(request, response);
		}
	}
}

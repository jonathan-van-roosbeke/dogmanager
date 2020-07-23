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
import com.dogmanager.service.impl.CouleurServiceImpl;
import com.dogmanager.service.impl.RaceServiceImpl;

@WebServlet("/EditionChien")
public class EditionChien extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	RaceServiceImpl raceService;

	@Autowired
	CouleurServiceImpl couleurService;

	@Autowired
	private IChienService chienService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("races", raceService.getRaces());
		request.setAttribute("couleurs", couleurService.getCouleurs());
		request.getRequestDispatcher("/jsp/editer-chien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("utilisateur") == null) {
			request.getRequestDispatcher("/login").forward(request, response);
		} else {
			List<Chien> chiens = chienService
					.getChiensByUtilisateurId(((Utilisateur) session.getAttribute("utilisateur")).getId());
//
//			chienService.update(chien,new Chien(9999, "bbbb", 10, new Couleur(1, ""), new Race(3, ""),
//					utilisateurDao.selectUtilisateurtById(1)))
//			
//			
//			System.out.println(request.getParameter("numero-puce"));
//			System.out.println(request.getParameter("race"));
//			System.out.println(request.getParameter("couleur"));
//			System.out.println(request.getParameter("nom-chien"));
//			System.out.println(request.getParameter("age"));
//			this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request, response);
		}
	}
}

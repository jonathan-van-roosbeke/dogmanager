package com.dogmanager.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.bean.Chien;
import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.IChienService;

@WebServlet("/liste-utilisateur")
public class ListeChienUtilisateurServlet extends AbstractServletController {
	
	@Autowired
	private IChienService chienService;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Chien> chiens = chienService.getChiensByUtilisateurId(1);
		request.setAttribute("chiens", chiens);
		try {
			this.getServletContext().getRequestDispatcher("/jsp/liste-utilisateur.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) {
	}

}

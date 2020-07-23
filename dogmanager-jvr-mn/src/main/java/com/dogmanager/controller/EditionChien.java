package com.dogmanager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogmanager.controller.conf.AbstractServletController;
import com.dogmanager.service.impl.CouleurServiceImpl;
import com.dogmanager.service.impl.RaceServiceImpl;

@WebServlet("/EditionChien")
public class EditionChien extends AbstractServletController {
	private static final long serialVersionUID = 1L;

	@Autowired
	RaceServiceImpl raceService;

	@Autowired
	CouleurServiceImpl couleurService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("ok");
		request.setAttribute("races", raceService.getRaces());
		request.setAttribute("couleurs", couleurService.getCouleurs());
		request.getRequestDispatcher("/jsp/editer-chien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}

package com.dogmanager.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Chien;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.service.IChienService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class ChienServiceImpl implements IChienService {

	@Autowired
	IChienDao chienDao;

	@Override
	public List<Chien> getChiens() {
		return chienDao.getChiens();
	}

	@Override
	public List<Chien> getChiensByUtilisateurId(int id) {
		return chienDao.getChiensByUtilisateurId(id);
	}

	@Override
	public Chien update(Chien chien, HttpServletRequest request) {
//		int numeroPuce = Integerequest.getParameter("numero-puce");
//		String race = request.getParameter("race");
//		String couleur = request.getParameter("couleur");
//		String nomChien = request.getParameter("nom-chien");
//		String age = request.getParameter("age");
//		return chienDao.update(chien, newChien);
		return null;
	}

}

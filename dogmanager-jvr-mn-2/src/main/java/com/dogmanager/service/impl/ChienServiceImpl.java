package com.dogmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Chien;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.dto.RetourService;
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
	public RetourService<Chien> ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace) {
		return chienDao.ajouterChien(idPuce, nomChien, ageChien, idCouleur, idRace);
	}

	@Override
	public void deleteChienById(int idPuce) {
		chienDao.deleteChienById(idPuce);
	}

	public RetourService<Chien> update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur, int idRace) {
		return chienDao.update(chien, idPuce, nomChien, ageChien, idCouleur, idRace);
	}

	@Override
	public Chien getChienById(int id) {
		return chienDao.getChienById(id);
	}
}

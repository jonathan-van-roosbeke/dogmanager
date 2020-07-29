package com.dogmanager.service.impl;

import java.util.List;

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
		return chienDao.findAll();
	}

	@Override
	public List<Chien> getChiensByUtilisateurId(int id) {
		return chienDao.getChiensByUtilisateurId(id);
	}

	@Override
	public Chien ajouterChien(Chien chien) {
		try {
			return chienDao.save(chien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteChienById(int idPuce) {
		try {
			chienDao.delete(chienDao.findById(idPuce));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Chien update(Chien chien, Chien newChien) {
		try {
			return chienDao.update(chien, newChien);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Chien getChienById(int id) {
		return chienDao.findById(id);
	}

	@Override
	public List<Chien> findAllPagination(int idUtilisateur, int pageNumber) {
		return chienDao.findAllPagination(idUtilisateur, pageNumber);
	}

	@Override
	public long getNombreDeChien(int idUtilisateur) {
		return chienDao.getNombreDeChien(idUtilisateur);
	}

	@Override
	public Chien getChienByPuceId(int idPuce, int idUtilisateur) {
		return chienDao.getChienByPuceId(idPuce, idUtilisateur);
	}
}
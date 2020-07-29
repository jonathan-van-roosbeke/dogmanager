package com.dogmanager.dao.impl;

import java.util.List;

import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Chien;
import com.dogmanager.constant.Constant;
import com.dogmanager.dao.IChienDao;

@Repository
public class ChienDaoImpl extends GenericDao<Chien, Integer> implements IChienDao {

	public ChienDaoImpl() {
		super(Chien.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chien> getChiensByUtilisateurId(int id) {
		return em.createQuery("FROM Chien WHERE id_utilisateur= :id").setParameter("id", id).getResultList();
	}

	@Override
	public Chien update(Chien chien, Chien newChien) throws Exception {

		EntityTransaction tx = null;
		try {

			tx = em.getTransaction();
			tx.begin();
			Chien vChien = (Chien) em.find(Chien.class, chien.getIdChien());
			vChien.setIdPuceChien(newChien.getIdPuceChien());
			vChien.setNomChien(newChien.getNomChien());
			vChien.setIdCouleur(newChien.getIdCouleur());
			vChien.setIdRace(newChien.getIdRace());
			vChien.setAgeChien(newChien.getAgeChien());
			tx.commit();
			tx = em.getTransaction();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		}

		return newChien;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Chien> findAllPagination(int idUtilisateur, int pageNumber) {
		return em.createQuery("FROM Chien WHERE id_utilisateur= :idUtilisateur")
				.setParameter("idUtilisateur", idUtilisateur).setFirstResult((pageNumber - 1) * Constant.PAGE_SIZE)
				.setMaxResults(Constant.PAGE_SIZE).getResultList();

	}

	@Override
	public long getNombreDeChien(int idUtilisateur) {
		Query query = em.createQuery("SELECT COUNT(*) FROM Chien where id_utilisateur =:idUtilisateur");
		query.setParameter("idUtilisateur", idUtilisateur);
		return (long) query.getSingleResult();
	}

	@Override
	public Chien getChienByPuceId(int idPuce, int idUtilisateur) {
		return (Chien) em
				.createQuery("FROM Chien WHERE id_puce_chien= :id_puce_chien and id_utilisateur = :idUtilisateur")
				.setParameter("id_puce_chien", idPuce).setParameter("idUtilisateur", idUtilisateur).getSingleResult();
	}
}
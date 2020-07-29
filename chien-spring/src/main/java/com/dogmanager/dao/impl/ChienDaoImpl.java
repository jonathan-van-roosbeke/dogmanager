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
			em.createNativeQuery(
					"UPDATE Chien SET id_puce_chien =:nIdPuce, nom_chien =:nName , age_chien =:nAge, id_couleur=:nCouleur, id_race=:nIdRace WHERE id_puce_chien = :idPuce  and id_utilisateur =:idUtilisateur")
					.setParameter("nIdPuce", newChien.getIdPuceChien()).setParameter("nName", newChien.getNomChien())
					.setParameter("nAge", newChien.getAgeChien()).setParameter("nCouleur", newChien.getIdCouleur())
					.setParameter("nIdRace", newChien.getIdRace()).setParameter("idPuce", chien.getIdPuceChien())
					.setParameter("idUtilisateur", chien.getIdUtilisateur()).executeUpdate();
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
		Query query = em.createQuery("From Chien where id_utilisateur = :idUtilisateur");
		query.setParameter("idUtilisateur", idUtilisateur);
		query.setFirstResult((pageNumber - 1) * Constant.PAGE_SIZE);
		query.setMaxResults(Constant.PAGE_SIZE);
		return query.getResultList();
	}

	@Override
	public long getNombreDeChien(int idUtilisateur) {
		Query query = em.createQuery("SELECT COUNT(*) FROM Chien where id_utilisateur =:idUtilisateur");
		query.setParameter("idUtilisateur", idUtilisateur);
		return (long) query.getSingleResult();
	}
}
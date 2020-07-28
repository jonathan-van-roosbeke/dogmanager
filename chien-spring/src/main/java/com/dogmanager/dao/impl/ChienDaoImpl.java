package com.dogmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Chien;
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

		em.getTransaction().begin();
		em.createNativeQuery(
				"UPDATE Chien SET id_puce_chien =:nIdPuce, nom_chien =:nName , age_chien =:nAge, id_couleur=:nCouleur, id_race=:nIdRace WHERE id_puce_chien = :idPuce  and id_utilisateur =:idUtilisateur")
				.setParameter("nIdPuce", newChien.getIdPuceChien()).setParameter("nName", newChien.getNomChien())
				.setParameter("nAge", newChien.getAgeChien()).setParameter("nCouleur", newChien.getIdCouleur())
				.setParameter("nIdRace", newChien.getIdRace()).setParameter("idPuce", chien.getIdPuceChien())
				.setParameter("idUtilisateur", chien.getIdUtilisateur()).executeUpdate();
		em.getTransaction().commit();
		return newChien;
	}
}
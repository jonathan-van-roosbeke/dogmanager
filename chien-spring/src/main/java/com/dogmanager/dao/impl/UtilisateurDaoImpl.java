package com.dogmanager.dao.impl;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;

@Repository
public class UtilisateurDaoImpl extends GenericDao<Utilisateur, Integer> implements IUtilisateurDao {

	public UtilisateurDaoImpl() {
		super(Utilisateur.class);
	}

	@Override
	public Utilisateur connexion(String login, String password) {
		return (Utilisateur) em.createQuery("FROM Utilisateur WHERE login= :login and password = MD5(:pass)")
				.setParameter("login", login).setParameter("pass", password).getSingleResult();
	}

	@Override
	public Utilisateur inscription(Utilisateur utilisateur) {
		try {
			return (Utilisateur) save(utilisateur);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByLogin(String login) {
		try {
			delete(findByLogin(login));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Utilisateur findByLogin(String login) {
		return (Utilisateur) em.createQuery("FROM Utilisateur WHERE login= :login and password = MD5(:pass)")
				.setParameter("login", login).getSingleResult();
	}
}
package com.dogmanager.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.dto.RetourService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Utilisateur connexion(String login, String password) {

		Session session = this.sessionFactory.openSession();
		Utilisateur personList = (Utilisateur) session.createQuery("from Utilisateur where login = 'momo'")
				.getSingleResult();
		session.close();
		return personList;
	}

	@Override
	public RetourService<Utilisateur> inscription(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteByLogin(String login) {
		// TODO Auto-generated method stub
		return 0;
	}
}
package com.dogmanager.dao;

import com.dogmanager.bean.Utilisateur;

public interface IUtilisateurDao {

	public Utilisateur connexion(String login, String password);

	public boolean inscription(Utilisateur utilisateur);

//	public Utilisateur selectUtilisateurtById(int id);

	public int deleteByLogin(String login);

//	public int updateUtilisateur(Utilisateur utilisateur);

//	public int deleteUserById(int id);

//	public List<Utilisateur> getUserList();
}

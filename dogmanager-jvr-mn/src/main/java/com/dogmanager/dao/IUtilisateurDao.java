package com.dogmanager.dao;

import com.dogmanager.bean.Utilisateur;

public interface IUtilisateurDao {

	public Utilisateur connexion(String login, String password);

	public Utilisateur selecUsertById(int id);

	public int addUtilisateur(Utilisateur utilisateur);

//	public int updateUtilisateur(Utilisateur utilisateur);

//	public int deleteUserById(int id);

//	public List<Utilisateur> getUserList();
}

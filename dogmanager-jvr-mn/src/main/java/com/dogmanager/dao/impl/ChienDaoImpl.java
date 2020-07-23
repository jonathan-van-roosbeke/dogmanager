package com.dogmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Chien;
import com.dogmanager.bean.Couleur;
import com.dogmanager.bean.Race;
import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.dao.conf.IDatabaseConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class ChienDaoImpl implements IChienDao {

	Connection connection;
	
	@Autowired
	public ChienDaoImpl(@Qualifier("connexionMariadb") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}
	
	@Override
	public List<Chien> getChiens() {
		List<Chien> chiens = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT ch.id_puce_chien, ch.nom_chien, ch.age_chien, "
							+ "r.id_race, r.nom_race, c.id_couleur, c.couleur, "
							+ "u.id_utilisateur, u.nom_utilisateur, u.prenom_utilisateur, u.login, u.password " + 
					"FROM chien AS ch " + 
					"JOIN " + 
					"race AS r " + 
					"ON ch.id_race = r.id_race " + 
					"JOIN " + 
					"couleur AS c " + 
					"ON ch.id_couleur = c.id_couleur " + 
					"JOIN " + 
					"utilisateur AS u " + 
					"ON ch.id_utilisateur = u.id_utilisateur;");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chien chien = new Chien();
				Couleur couleur = new Couleur();
				Race race = new Race();
				Utilisateur utilisateur = new Utilisateur();
				
				chien.setIdPuceChien(rs.getInt("ch.id_puce_chien"));
				chien.setNomChien(rs.getString("ch.nom_chien"));
				chien.setAgeChien(rs.getInt("ch.age_chien"));
				race.setIdRace(rs.getInt("r.id_race"));
				race.setNomRace(rs.getString("r.nom_race"));
				couleur.setIdCouleur(rs.getInt("c.id_couleur"));
				couleur.setCouleur(rs.getString("c.couleur"));
				utilisateur.setId(rs.getInt("u.id_utilisateur"));
				utilisateur.setNom(rs.getString("u.nom_utilisateur"));
				utilisateur.setPrenom(rs.getString("u.prenom_utilisateur"));
				utilisateur.setLogin(rs.getString("u.login"));
				utilisateur.setLogin(rs.getString("u.password"));
				
				chien.setCouleur(couleur);
				chien.setRace(race);
				chien.setUtilisateur(utilisateur);
				
				chiens.add(chien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chiens;
	}

	@Override
	public List<Chien> getChiensByUtilisateurId(int id) {
		List<Chien> chiens = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT ch.id_puce_chien, ch.nom_chien, ch.age_chien, "
							+ "r.id_race, r.nom_race, c.id_couleur, c.couleur, "
							+ "u.id_utilisateur, u.nom_utilisateur, u.prenom_utilisateur, u.login, u.password " + 
					"FROM chien AS ch " + 
					"JOIN " + 
					"race AS r " + 
					"ON ch.id_race = r.id_race " + 
					"JOIN " + 
					"couleur AS c " + 
					"ON ch.id_couleur = c.id_couleur " + 
					"JOIN " + 
					"utilisateur AS u " + 
					"ON ch.id_utilisateur = u.id_utilisateur " +
					"WHERE u.id_utilisateur = (?)");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chien chien = new Chien();
				Couleur couleur = new Couleur();
				Race race = new Race();
				Utilisateur utilisateur = new Utilisateur();
				
				chien.setIdPuceChien(rs.getInt("ch.id_puce_chien"));
				chien.setNomChien(rs.getString("ch.nom_chien"));
				chien.setAgeChien(rs.getInt("ch.age_chien"));
				race.setIdRace(rs.getInt("r.id_race"));
				race.setNomRace(rs.getString("r.nom_race"));
				couleur.setIdCouleur(rs.getInt("c.id_couleur"));
				couleur.setCouleur(rs.getString("c.couleur"));
				utilisateur.setId(rs.getInt("u.id_utilisateur"));
				utilisateur.setNom(rs.getString("u.nom_utilisateur"));
				utilisateur.setPrenom(rs.getString("u.prenom_utilisateur"));
				utilisateur.setLogin(rs.getString("u.login"));
				utilisateur.setLogin(rs.getString("u.password"));
				
				chien.setCouleur(couleur);
				chien.setRace(race);
				chien.setUtilisateur(utilisateur);
				
				chiens.add(chien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chiens;
	}

	@Override
	public void ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace, int idUtilisateur) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (?, ?, ?, ?, ?, ?);");
			ps.setInt(1, idPuce);
			ps.setString(2, nomChien);
			ps.setInt(3, ageChien);
			ps.setInt(4, idCouleur);
			ps.setInt(5, idRace);
			ps.setInt(6, idUtilisateur);
			ps.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteChienById(int idPuce) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"delete from chien where id_puce_chien = ?");
			ps.setInt(1, idPuce);
			ps.executeUpdate();
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

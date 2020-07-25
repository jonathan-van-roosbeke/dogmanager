package com.dogmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
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
import com.dogmanager.dto.RetourService;
import com.dogmanager.service.ICouleurService;
import com.dogmanager.service.IRaceService;
import com.dogmanager.service.IUtilisateurService;

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
	IUtilisateurService utilisateurService;
	@Autowired
	IRaceService raceService;
	@Autowired
	ICouleurService couleurService;

	@Autowired
	public ChienDaoImpl(@Qualifier("connexionMariadb") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public List<Chien> getChiens() {
		List<Chien> chiens = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement("SELECT ch.id_puce_chien, ch.nom_chien, ch.age_chien, "
				+ "r.id_race, r.nom_race, c.id_couleur, c.couleur, "
				+ "u.id_utilisateur, u.nom_utilisateur, u.prenom_utilisateur, u.login, u.password "
				+ "FROM chien AS ch " + "JOIN " + "race AS r " + "ON ch.id_race = r.id_race " + "JOIN "
				+ "couleur AS c " + "ON ch.id_couleur = c.id_couleur " + "JOIN " + "utilisateur AS u "
				+ "ON ch.id_utilisateur = u.id_utilisateur;")) {
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
				utilisateur.setLogin(rs.getString("u.password"));

				chien.setCouleur(couleur);
				chien.setRace(race);
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
		try (PreparedStatement ps = connection.prepareStatement(
				"SELECT ch.*, r.*, c.*  " + "FROM chien AS ch " + "JOIN race AS r " + "ON ch.id_race = r.id_race "
						+ "JOIN  couleur AS c " + "ON ch.id_couleur = c.id_couleur  " + "JOIN utilisateur AS u "
						+ "ON ch.id_utilisateur = u.id_utilisateur " + "WHERE u.id_utilisateur = ?;");) {

			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chien chien = new Chien();

				chien.setIdPuceChien(rs.getInt("ch.id_puce_chien"));
				chien.setNomChien(rs.getString("ch.nom_chien"));
				chien.setAgeChien(rs.getInt("ch.age_chien"));
				chien.setCouleur(couleurService.getCouleurById(rs.getInt("ch.id_couleur")));
				chien.setRace(raceService.getRaceById(rs.getInt("ch.id_race")));
				chiens.add(chien);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chiens;
	}

	@Override
	public RetourService<Chien> ajouterChien(int idPuce, String nomChien, int ageChien, int idCouleur, int idRace) {
		RetourService<Chien> resultat = new RetourService<>();
		try (PreparedStatement ps = connection.prepareStatement(
				"insert into chien (id_puce_chien, nom_chien, age_chien, id_couleur, id_race, id_utilisateur) values (?, ?, ?, ?, ?, ?);");) {
			ps.setInt(1, idPuce);
			ps.setString(2, nomChien);
			ps.setInt(3, ageChien);
			ps.setInt(4, idCouleur);
			ps.setInt(5, idRace);
			ps.setInt(6, utilisateurService.getCurentUtilisateurId());
			ps.executeUpdate();
			resultat.setContenu(null);
			resultat.setReussi(true);
			resultat.setMsg("Mise a jour avec sucsee");
		} catch (SQLIntegrityConstraintViolationException e) {
			resultat.setReussi(false);
			resultat.setMsg("Failed: id chien existe deja");
		} catch (SQLException e) {
			resultat.setReussi(false);
			resultat.setMsg("Failed !");
		}
		return resultat;
	}

	@Override
	public RetourService<Chien> update(Chien chien, int idPuce, String nomChien, int ageChien, int idCouleur,
			int idRace) {
		RetourService<Chien> resultat = new RetourService<>();
		String query = "UPDATE chien SET id_puce_chien = ?, nom_chien = ?, age_chien =?, id_couleur=?, id_race=? WHERE id_puce_chien = ?  and id_utilisateur = ?; ";
		try (PreparedStatement ps = connection.prepareStatement(query);) {

			ps.setInt(1, idPuce);
			ps.setString(2, nomChien);
			ps.setInt(3, ageChien);
			ps.setInt(4, idCouleur);
			ps.setInt(5, idRace);
			ps.setInt(6, chien.getIdPuceChien());
			ps.setInt(7, utilisateurService.getCurentUtilisateurId());
			ps.executeUpdate();
			resultat.setContenu(null);
			resultat.setReussi(true);
			resultat.setMsg("Mise a jour avec sucsee");
		} catch (SQLIntegrityConstraintViolationException e) {
			resultat.setReussi(false);
			resultat.setMsg("Failed: id chien existe deja");
		} catch (SQLException e) {
			resultat.setReussi(false);
			resultat.setMsg("Failed");
		}
		return resultat;
	}

	@Override
	public void deleteChienById(int idPuce) {
		try (PreparedStatement ps = connection.prepareStatement("delete from chien where id_puce_chien = ?");) {
			ps.setInt(1, idPuce);
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Chien getChienById(int idPuce) {
		try (PreparedStatement ps = connection
				.prepareStatement("select * from chien where id_puce_chien = ?  and id_utilisateur = ?;");) {
			ps.setInt(1, idPuce);
			ps.setInt(2, utilisateurService.getCurentUtilisateurId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Chien(rs.getInt(1), rs.getString(2), rs.getInt(3),
						couleurService.getCouleurById(rs.getInt(4)), raceService.getRaceById(rs.getInt(5)));// ,
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
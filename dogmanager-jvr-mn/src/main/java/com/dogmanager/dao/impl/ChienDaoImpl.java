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
					"select * from chien");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chien c = new Chien();
				c.setIdPuceChien(rs.getInt("id_puce_chien"));
				c.setNomChien(rs.getString("nom_chien"));
				c.setAgeChien(rs.getInt("age_chien"));
				c.setIdCouleur(rs.getInt("id_couleur"));
				c.setIdRace(rs.getInt("id_race"));
				c.setIdUtilisateur(rs.getInt("id_utilisateur"));
				chiens.add(c);
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
					"select * from UTILISATEUR u join chien c on c.id_utilisateur = u.ID_UTILISATEUR where u.ID_UTILISATEUR = (?);");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chien c = new Chien();
				c.setIdPuceChien(rs.getInt("id_puce_chien"));
				c.setNomChien(rs.getString("nom_chien"));
				c.setAgeChien(rs.getInt("age_chien"));
				c.setIdCouleur(rs.getInt("id_couleur"));
				c.setIdRace(rs.getInt("id_race"));
				c.setIdUtilisateur(rs.getInt("id_utilisateur"));
				chiens.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chiens;
	}
}

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

import com.dogmanager.bean.Couleur;
import com.dogmanager.bean.Couleur;
import com.dogmanager.dao.ICouleurDao;
import com.dogmanager.dao.conf.IDatabaseConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CouleurDaoImpl implements ICouleurDao {
	
	private Connection connection;

	@Autowired
	public CouleurDaoImpl(@Qualifier("connexionMariadb") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public List<Couleur> getCouleurs() {
		List<Couleur> couleurs = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"select * from couleur");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Couleur c = new Couleur();
				c.setIdCouleur(rs.getInt("id_couleur"));
				c.setCouleur(rs.getString("couleur"));
				couleurs.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return couleurs;
	}

}

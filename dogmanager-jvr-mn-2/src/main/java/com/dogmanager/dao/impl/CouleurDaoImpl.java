package com.dogmanager.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Couleur;
import com.dogmanager.dao.ICouleurDao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Repository
@AllArgsConstructor
@Data
public class CouleurDaoImpl implements ICouleurDao {
	@Override
	public Couleur getCouleurById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Couleur> getCouleurs() {
		// TODO Auto-generated method stub
		return null;
	}
//
//	@Override
//	public Couleur getCouleurById(int id) {
//		try {
//			PreparedStatement ps = connection.prepareStatement("select * from couleur where id_couleur =?");
//			ps.setInt(1, id);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				return new Couleur(rs.getInt(1), rs.getString(2));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//
//	@Override
//	public List<Couleur> getCouleurs() {
//		List<Couleur> couleurs = new ArrayList<>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("select * from couleur");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Couleur c = new Couleur();
//				c.setIdCouleur(rs.getInt("id_couleur"));
//				c.setCouleur(rs.getString("couleur"));
//				couleurs.add(c);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return couleurs;
//	}
}

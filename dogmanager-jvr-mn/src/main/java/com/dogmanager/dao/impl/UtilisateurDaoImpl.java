package com.dogmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.dao.conf.IDatabaseConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Repository
public class UtilisateurDaoImpl implements IUtilisateurDao {

	private Connection connection;

	@Autowired
	public UtilisateurDaoImpl(@Qualifier("connexionMariadb") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public Utilisateur connexion(String login, String password) {
		try {
			String query = "select * from utilisateur where login = ? and password = md5(?)";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, login);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						null);
				// TODO passer la liste des chiens au lieu de null
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean inscription(Utilisateur utilisateur) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"insert into utilisateur (nom_utilisateur, prenom_utilisateur, login, password) value(?,?,?,md5(?))");
			ps.setString(1, utilisateur.getNom());
			ps.setString(2, utilisateur.getPrenom());
			ps.setString(3, utilisateur.getLogin());
			ps.setString(4, utilisateur.getPassword());
			return ps.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Utilisateur selectUtilisateurtById(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("select * from utilisateur where id_utilisateur = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				// TODO remplacer null par la liste des chiens.
				return new Utilisateur(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						null);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int deleteByLogin(String login) {
		try {
			PreparedStatement ps = connection.prepareStatement("delete from utilisateur where login=?;");
			ps.setString(1, login);
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;

	}

//	@Override
//	public int updateUtilisateur(Utilisateur utilisateur) {
//		try {
//			PreparedStatement ps = connection
//					.prepareStatement("update utilisateur set  password_utilisateur=? where login=?;");
//			ps.setString(1, utilisateur.getPassword());
//			ps.setString(2, utilisateur.getLogin());
//			return ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}

//	@Override
//	public void deleteUserById(int id) {
//		try {
//
//			PreparedStatement ps = connection.prepareStatement("delete from utilisateur where id=?;");
//			ps.setInt(1, id);
//			ps.executeQuery();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

//	@Override
//	public List<Utilisateur> getUtilisateurList() {
//		List<Utilisateur> utilisateurs = new ArrayList<>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("select * from utilisateur;");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Utilisateur u = new Utilisateur();
//				u.setId(rs.getInt(1));
//				u.setName(rs.getString(2));
//				u.setLname(rs.getString(3));
//				u.setLogin(rs.getString(4));
//				u.setPassword(rs.getString(5));
//				user.add(u);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return utilisateurs;
//	}
}
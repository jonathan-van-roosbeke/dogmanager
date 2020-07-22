package com.dogmanager.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.dogmanager.bean.User;
import com.dogmanager.dao.IUserDao;
import com.dogmanager.dao.conf.IDatabaseConnection;

public class UserDaoImpl implements IUserDao {

	private Connection connection;

	@Autowired
	public UserDaoImpl(@Qualifier("connexionMysql") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public User selecUsertById(int id) {
		return null;
	}

	@Override
	public int addUser(User user) {

		try {
			PreparedStatement ps = connection.prepareStatement("insert into utilisateur value(?,?,?,?)");

			ps.setString(1, user.getName());
			ps.setString(2, user.getLname());
			ps.setNString(3, user.getLogin());
			ps.setNString(4, user.getPassword());
			return ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateUser(User user) {
		try {
			PreparedStatement ps = connection.prepareStatement(
					"update utilisateur set  nom_utilisateur=?, prenom_utilisateur=?, password_utilisateur=? where login=?;");
			ps.setString(1, user.getName());
			ps.setString(2, user.getLname());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getLogin());
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

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
//	public List<User> getUserList() {
//		List<User> user = new ArrayList<>();
//		try {
//			PreparedStatement ps = connection.prepareStatement("select * from utilisateur;");
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				User u = new User();
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
//		return user;
//	}
}
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

import com.dogmanager.bean.Race;
import com.dogmanager.dao.IRaceDao;
import com.dogmanager.dao.conf.IDatabaseConnection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Repository
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RaceDaoImpl implements IRaceDao {

	private Connection connection;

	@Autowired
	public RaceDaoImpl(@Qualifier("connexionMariadb") IDatabaseConnection databaseConnection) {
		this.connection = databaseConnection.getConnection();
	}

	@Override
	public List<Race> getRaces() {
		List<Race> races = new ArrayList<>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from race");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Race r = new Race();
				r.setIdRace(rs.getInt("id_race"));
				r.setNomRace(rs.getString("nom_race"));
				races.add(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return races;
	}

	@Override
	public Race getRaceById(int id) {
		try {
			PreparedStatement ps = connection.prepareStatement("select * from race where id_race =?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return new Race(rs.getInt(1), rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}

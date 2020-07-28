//package com.dogmanager.dao.conf;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//@Component("connexionMariadb")
//public class DatabaseConnectionMariadb implements IDatabaseConnection {
//
//	@Autowired
//	private DataSourceMariadb dataSourceMariadb;
//
//	private Connection connexion = null;
//
//	@Override
//	public Connection getConnection() {
//		if (connexion == null) {
//			try {
//				Class.forName(dataSourceMariadb.getDriver());
//				connexion = DriverManager.getConnection(dataSourceMariadb.getUrl(), dataSourceMariadb.getUtilisateur(),
//						dataSourceMariadb.getMotDePasse());
//			} catch (Exception e) {
//				e.printStackTrace();
//
//			}
//		}
//		return connexion;
//	}
//
//	@Override
//	public void stop() {
//		if (connexion != null) {
//			try {
//				connexion.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}

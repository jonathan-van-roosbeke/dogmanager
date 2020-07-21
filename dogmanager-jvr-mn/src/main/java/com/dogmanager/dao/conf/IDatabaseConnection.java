package com.dogmanager.dao.conf;

import java.sql.Connection;

public interface IDatabaseConnection {
	public Connection getConnection();
	public void stop();
}

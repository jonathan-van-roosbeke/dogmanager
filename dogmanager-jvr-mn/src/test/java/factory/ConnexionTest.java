package factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.dao.conf.IDatabaseConnection;
import com.dogmanager.dao.impl.ChienDaoImpl;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

class ConnexionTest {

	private static ApplicationContext context;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
	}

	@Test
	public void connexion() {
		Connection c = context.getBean("connexionMariadb", IDatabaseConnection.class).getConnection();
		assertNotNull(c);
	}

	@Test
	public void request() {
		Integer i = null;
		try {
			Connection c = context.getBean("connexionMariadb", IDatabaseConnection.class).getConnection();
			assertNotNull(c);
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery("select 1");
			while (r.next()) {
				i = r.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		assertEquals(1, i);
	}
}

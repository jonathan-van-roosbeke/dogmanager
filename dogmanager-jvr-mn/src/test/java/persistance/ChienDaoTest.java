package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

public class ChienDaoTest {

	private static ApplicationContext context;
	private static IChienDao chien;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		chien = context.getBean(IChienDao.class);
	}

	@Test
	public void getChiensTest() {
		List<Chien> chiens = chien.getChiens();
		assertNotNull(chiens);
	}

	@Test
	public void getChiensByUtilisateurIdTest() {
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}

	@Test
	public void ajoutChienTest() {
		chien.ajouterChien(111, "coucou-test", 5, 1, 1, 2);
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 3);
		
	}
	
	@Test
	public void deleteChienTest() {
		chien.deleteChienById(111);
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}
}

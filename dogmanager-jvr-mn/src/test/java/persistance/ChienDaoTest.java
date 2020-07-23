package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.bean.Couleur;
import com.dogmanager.bean.Race;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

public class ChienDaoTest {

	private static ApplicationContext context;
	private static IChienDao chienDao;
	private static IUtilisateurDao utilisateurDao;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		chienDao = context.getBean(IChienDao.class);
		utilisateurDao = context.getBean(IUtilisateurDao.class);
	}

	@Test
	public void getChiensTest() {
		List<Chien> chiens = chienDao.getChiens();
		assertNotNull(chiens);
	}

	@Test
	public void getChienById() {
		Chien chien = chienDao.getChienById(139);
		assertNotNull(chien);
	}

	@Test
	public void getChiensByUtilisateurIdTest() {
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}

	@Test
	public void ajoutChienTest() {
		chienDao.ajouterChien(111, "coucou-test", 5, 1, 1, 2);
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(1);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 3);

	}

	@Test
	public void deleteChienTest() {
		chienDao.deleteChienById(111);
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}

	@Test
	public void updateChienTest() {
		Chien chien = chienDao.getChiensByUtilisateurId(1).get(0);
		Chien newChien = chienDao.update(chien, new Chien(93, "bbbb", 10, new Couleur(1, ""), new Race(3, ""),
				utilisateurDao.selectUtilisateurtById(1)));
		assertNotNull(newChien);
		assertEquals(newChien.getIdPuceChien(), 93);
	}
}

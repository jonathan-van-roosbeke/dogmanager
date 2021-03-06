package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IChienDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

@TestMethodOrder(Alphanumeric.class)
class ChienDaoTest {

	private static ApplicationContext context;
	private static IChienDao chienDao;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		chienDao = context.getBean(IChienDao.class);
	}

	@Test
	void aGetChiensTest() {
		List<Chien> chiens = chienDao.getChiens();
		assertNotNull(chiens);
	}

	@Test
	void cGetChiensByUtilisateurIdTest() {
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(1);
		assertNotNull(chiens);
		assertEquals(3, chiens.size());
	}

	@Test
	void dAjoutChienTest() {
		Utilisateur u = new Utilisateur();
		u.setId(1);
		chienDao.ajouterChien(222, "coucou-test", 5, 1, 1);
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(1);
		assertNotNull(chiens);
		assertEquals(3, chiens.size());

	}

	@Test
	void eGetChienById() {
		Chien chien = chienDao.getChienById(222);
		assertNotNull(chien);
	}

	@Test
	void fUpdateChienTest() {
		Utilisateur u = new Utilisateur();
		u.setId(1);
		Chien chien = chienDao.getChiensByUtilisateurId(1).get(0);
		chienDao.update(chien, 222, "kkk", 5, 1, 1);
		assertNotNull(chienDao.getChienById(222));
		assertEquals("kkk", chienDao.getChienById(222).getNomChien());
	}

	@Test
	void gDeleteChienTest() {
		chienDao.deleteChienById(222);
		List<Chien> chiens = chienDao.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(2, chiens.size());
	}
}

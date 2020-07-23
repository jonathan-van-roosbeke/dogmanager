package persistance;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dao.IUtilisateurDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

public class UtilisateurDaoTest {
	private static IUtilisateurDao utilisateurDao;
	private static ApplicationContext context;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		utilisateurDao = context.getBean(IUtilisateurDao.class);
	}

	@Test
	public void inscription() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("momo123");
		utilisateur.setPrenom("momo123");
		utilisateur.setLogin("momo1235");
		utilisateur.setPassword("momo123");
		int resultat = utilisateurDao.inscription(utilisateur);
		assertNotEquals(0, resultat);
	}

	@Test
	public void connexion() {
		Utilisateur user = utilisateurDao.connexion("momo1235", "momo123");
		assertNotNull(user);
		assertNotEquals(0, user.getId());
	}

	@Test
	public void selectUtilisateurtById() {
		Utilisateur user = utilisateurDao.selectUtilisateurtById(1);
		assertNotNull(user);
	}

	@Test
	public void delete() {
		int resultat = utilisateurDao.deleteByLogin("momo1235");
		assertNotEquals(0, resultat);
	}
}
package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Couleur;
import com.dogmanager.dao.ICouleurDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

public class CouleurDaoTest {
	private static ApplicationContext context;
	private static ICouleurDao couleur;
	
	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		couleur = context.getBean(ICouleurDao.class);
	}
	
	@Test
	public void getCouleursTest() {
		List<Couleur> couleurs = couleur.getCouleurs();
		assertNotNull(couleurs);
		assertEquals(couleurs.size(), 5);
	}
}

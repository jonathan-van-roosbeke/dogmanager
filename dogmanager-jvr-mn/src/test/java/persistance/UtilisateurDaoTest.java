package persistance;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.Alphanumeric;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Utilisateur;
import com.dogmanager.dto.RetourService;
import com.dogmanager.service.IUtilisateurService;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

@TestMethodOrder(Alphanumeric.class)
public class UtilisateurDaoTest {
	private static IUtilisateurService utilisateurService;
	private static ApplicationContext context;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		utilisateurService = context.getBean(IUtilisateurService.class);
	}

	@Test
	public void aInscription() {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom("momo123");
		utilisateur.setPrenom("momo123");
		utilisateur.setLogin("momo1235");
		utilisateur.setPassword("momo1235");
		RetourService<Utilisateur> resultat = utilisateurService.inscription(utilisateur);
		assertTrue(resultat.isReussi());
	}

	@Test
	public void cDelete() {
		int resultat = utilisateurService.deleteByLogin("momo1235");
		assertNotEquals(0, resultat);
	}

	@Test
	public void bConnexion() {
		Utilisateur user = utilisateurService.connexion("momo1235", "momo1235");
		assertNotNull(user);
		assertNotEquals(0, utilisateurService.getCurentUtilisateurId());
	}

}
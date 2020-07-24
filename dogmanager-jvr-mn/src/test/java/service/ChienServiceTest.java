package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.service.IChienService;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChienServiceTest {

	private static ApplicationContext context;
	private static IChienService chien;

	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		chien = context.getBean(IChienService.class);
	}

	@Test
	@Order(1)
	public void getChiensTest() {
		List<Chien> chiens = chien.getChiens();
		assertNotNull(chiens);
	}

	@Test
	@Order(2)
	public void getChiensByUtilisateurIdTest() {
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		System.out.println(chiens.size());
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}

	@Test
	@Order(3)
	public void ajoutChienServiceTest() {
		chien.ajouterChien(111, "coucou-test-service", 5, 1, 1);
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 3);

	}

	@Test
	@Order(4)
	public void deleteChienServiceTest() {
		chien.deleteChienById(111);
		List<Chien> chiens = chien.getChiensByUtilisateurId(2);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 2);
	}
}

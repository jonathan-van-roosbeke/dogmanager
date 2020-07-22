package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Chien;
import com.dogmanager.service.IChienService;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;


public class ChienServiceTest {
	
	private static ApplicationContext context;
	private static IChienService chien;
	
	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		chien = context.getBean(IChienService.class);
	}
	
	@Test
	public void getChiensTest() {
		List<Chien> chiens = chien.getChiens();
		assertNotNull(chiens);
	}
	
	@Test
	public void getChiensByUtilisateurIdTest() {
		List<Chien> chiens = chien.getChiensByUtilisateurId(1);
		assertNotNull(chiens);
		assertEquals(chiens.size(), 3);
	}

}

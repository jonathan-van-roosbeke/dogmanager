package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Couleur;
import com.dogmanager.bean.Race;
import com.dogmanager.dao.ICouleurDao;
import com.dogmanager.dao.IRaceDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

public class RaceDaoTest {
	
	private static ApplicationContext context;
	private static IRaceDao race;
	
	@BeforeAll
	public static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		race = context.getBean(IRaceDao.class);
	}
	
	@Test
	public void getCouleursTest() {
		List<Race> races = race.getRaces();
		assertNotNull(races);
		assertEquals(races.size(), 10);
	}
}

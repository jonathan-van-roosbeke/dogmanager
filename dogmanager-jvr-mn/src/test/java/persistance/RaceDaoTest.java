package persistance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;

import com.dogmanager.bean.Race;
import com.dogmanager.dao.IRaceDao;
import com.dogmanager.util.ContextConfigurationType;
import com.dogmanager.util.MyContextFactory;

class RaceDaoTest {

	private static ApplicationContext context;
	private static IRaceDao raceDao;

	@BeforeAll
	static void initAll() {
		context = MyContextFactory.getContext(ContextConfigurationType.CLASSPATH);
		raceDao = context.getBean(IRaceDao.class);
	}

	@Test
	void getRaceByIdTest() {
		Race race = raceDao.getRaceById(1);
		assertNotNull(race);
		assertEquals(race.getNomRace(), "border collie");
	}

	@Test
	void getCouleursTest() {
		List<Race> races = raceDao.getRaces();
		assertNotNull(races);
		assertEquals(races.size(), 10);
	}
}

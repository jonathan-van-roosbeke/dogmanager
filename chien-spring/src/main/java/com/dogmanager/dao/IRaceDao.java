package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Race;

/**
 * IRaceDao.java Interface contenant les methodes ci-dessous.
 * 
 * @author Jonathan Van Roosbeke
 * @since 24/07/2020
 */

public interface IRaceDao {
	Race findById(Integer id);

	void delete(Race raceToDelete) throws Exception;

	List<Race> findAll();

	Race save(Race Race) throws Exception;
}

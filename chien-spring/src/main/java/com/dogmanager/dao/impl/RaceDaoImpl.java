package com.dogmanager.dao.impl;

import org.springframework.stereotype.Repository;

import com.dogmanager.bean.Race;
import com.dogmanager.dao.IRaceDao;

@Repository
public class RaceDaoImpl extends GenericDao<Race, Integer> implements IRaceDao {

	public RaceDaoImpl() {
		super(Race.class);
	}

}

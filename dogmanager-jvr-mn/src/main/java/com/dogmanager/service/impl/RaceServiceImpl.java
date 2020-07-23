package com.dogmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogmanager.bean.Race;
import com.dogmanager.dao.IRaceDao;
import com.dogmanager.service.IRaceService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Service
public class RaceServiceImpl implements IRaceService {

	@Autowired
	IRaceDao raceDao;

	@Override
	public List<Race> getRaces() {
		return raceDao.getRaces();
	}

	@Override
	public Race getRaceById(int id) {
		return raceDao.getRaceById(id);
	}
}

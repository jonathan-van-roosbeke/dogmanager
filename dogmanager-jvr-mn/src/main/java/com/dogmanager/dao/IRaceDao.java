package com.dogmanager.dao;

import java.util.List;

import com.dogmanager.bean.Race;

public interface IRaceDao {

	public Race getRaceById(int id);

	public List<Race> getRaces();

}

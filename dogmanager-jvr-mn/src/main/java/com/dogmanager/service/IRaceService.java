package com.dogmanager.service;

import java.util.List;

import com.dogmanager.bean.Race;

public interface IRaceService {

	public List<Race> getRaces();

	public Race getRaceById(int id);
}

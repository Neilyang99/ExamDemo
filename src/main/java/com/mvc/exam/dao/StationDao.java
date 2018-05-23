package com.mvc.exam.dao;

import java.util.List;

import com.mvc.exam.model.Station;

public interface StationDao {

	Station findById(int id);
	void saveStation(Station station);
	void deleteStationById(int id);
	Station findStationById(int id);
	List<Station> findAllStation();
}

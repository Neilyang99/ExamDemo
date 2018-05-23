package com.mvc.exam.service;

import java.util.List;

import com.mvc.exam.model.Station;

public interface StationService {

	Station findById(int id);
	void saveStation(Station station);
	void updateStation(Station station);
	void deleteStationById(int id);
	Station findStationById(int id);
	List<Station> findAllStation();
}

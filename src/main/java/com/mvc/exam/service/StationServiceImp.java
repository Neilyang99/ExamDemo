package com.mvc.exam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.exam.dao.StationDao;
import com.mvc.exam.model.Station;


@Service("stationService")
@Transactional
public class StationServiceImp implements StationService {

	@Autowired
	private StationDao dao;

	@Override
	public Station findById(int id) {
		return dao.findById(id);
	}

	@Override
	public void saveStation(Station station) {
		dao.saveStation(station);
	}

	@Override
	public void updateStation(Station station){
		Station entity = dao.findById(station.getId());
		if(entity!=null){
			entity.setStationName(station.getStationName());
			entity.setModifyDate(station.getModifyDate());
			entity.setStatus("Y");
		}
	}

	@Override
	public void deleteStationById(int id) {
		dao.deleteStationById(id);
	}

	@Override
	public Station findStationById(int id) {
		// TODO Auto-generated method stub
		return dao.findStationById(id);
	}

	@Override
	public List<Station> findAllStation() {
		// TODO Auto-generated method stub
		return dao.findAllStation();
	}
	
	

}

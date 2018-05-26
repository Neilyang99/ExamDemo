package com.mvc.exam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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
		Date date = new Date();
	    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");       
	    String str = dtFormat.format(date);  
		
		station.setModifyDate(str);
		station.setStatus("Y");
		dao.saveStation(station);
	}

	@Override
	public void updateStation(Station station){
		Station entity = dao.findById(station.getId());
		if(entity!=null){
			Date date = new Date();
		    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");       
		    String str = dtFormat.format(date);  
		    
			entity.setStationName(station.getStationName());
			entity.setModifyDate(str);
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
	
	/**
	 * check station name is unique or not
	 * @param id
	 * @param name
	 * @return
	 */
	public boolean isStationNameUnique(String name) {
		Station station = dao.findStationByName(name);
		if( station == null || ((name != null) && (!station.getStationName().equals(name)))){
			return true;
		}else{
			return false;
		}
	}

}

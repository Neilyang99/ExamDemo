package com.mvc.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mvc.exam.model.Station;

@Repository("stationDao")
public class StationDaoImp extends AbstractDao<Integer,Station> implements StationDao {

	@Override
	public Station findById(int id) {
		return getByKey(id);
	}

	@Override
	public void saveStation(Station station) {
		persist(station);
	}

	@Override
	public void deleteStationById(int id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
		Station station = (Station)crit.uniqueResult();
		delete(station);
	}

	@Override
	public Station findStationById(int id) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("id", id));
		Station station = (Station)crit.uniqueResult();
		return station;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Station> findAllStation() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("stationName"));
        List<Station> station = (List<Station>) criteria.list();
		return station;
	}

}

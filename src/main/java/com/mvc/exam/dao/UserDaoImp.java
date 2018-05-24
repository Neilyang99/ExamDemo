package com.mvc.exam.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.mvc.exam.model.User;

@Repository("UserDao")
public class UserDaoImp extends AbstractDao<Integer,User> implements UserDao {

	@Override
	public User findByID(int id) {
		return getByKey(id);
	}

	@Override
	public User findByEmpID(String empID) {
		Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("employeeID", empID));//get data by employee id
        User user = (User)crit.uniqueResult();
		return user;
	}

	@Override
	public void saveUser(User user) {
		persist(user);

	}

	@Override
	public void deleteUserByID(int id) {
		User user = getByKey(id);
		delete(user);
	}

	@Override
	public List<User> findAllUser() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("employeeID"));
		List<User> user =(List<User>)criteria.list();
		return user;
	}

}

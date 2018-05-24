package com.mvc.exam.dao;

import java.util.List;

import com.mvc.exam.model.User;

public interface UserDao {

	User findByID(int id);
	User findByEmpID(String empID);
	void saveUser(User user);
	void deleteUserByID(int id);
	List<User> findAllUser();
}

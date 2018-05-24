package com.mvc.exam.service;

import java.util.List;

import com.mvc.exam.model.User;

public interface UserService {

	User findByID(int id);
	User findByEmpID(String empID);
	void saveUser(User user);
	void deleteUserByID(int id);
	List<User> findAllUser();
	void updateUser(User user);
}

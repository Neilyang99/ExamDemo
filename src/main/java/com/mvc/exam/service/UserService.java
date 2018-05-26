package com.mvc.exam.service;

import java.util.List;

import com.mvc.exam.model.User;

public interface UserService {

	User findByID(int id);
	User findByEmpID(String empID);
	void saveUser(User user);
	void deleteUserByID(int id);
	List<User> findAllUser();
	List<User> findUserByStation(int StationID);
	void updateUser(User user);
	boolean isEmpIDUnique(String empID);
}

package com.mvc.exam.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.exam.dao.UserDao;
import com.mvc.exam.model.User;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User findByID(int id) {
		return dao.findByID(id);
	}

	@Override
	public User findByEmpID(String empID) {
		return dao.findByEmpID(empID);
	}

	@Override
	public void saveUser(User user) {
		Date date = new Date();
	    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");       
	    String str = dtFormat.format(date); 
	    user.setModifyDate(str);
	    user.setWorking("Y");
	    
		dao.saveUser(user);
	}

	@Override
	public void deleteUserByID(int id) {
		// TODO Auto-generated method stub
		dao.deleteUserByID(id);
	}

	@Override
	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return dao.findAllUser();
	}

	@Override
	public void updateUser(User user) {
		User entity = dao.findByID(user.getId());
		if(entity!=null){
			Date date = new Date();
		    SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");       
		    String str = dtFormat.format(date);  
		    
			entity.setEmployeeID(user.getEmployeeID());
			entity.setName(user.getName());
			entity.setModifyDate(str);
		}
		
	}

}

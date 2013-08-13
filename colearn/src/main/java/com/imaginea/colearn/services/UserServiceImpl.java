package com.imaginea.colearn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.dao.UserDetailsDAO;
import com.imaginea.colearn.model.UserDetailsTable;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
	public Integer createUserDetail(UserDetailsTable userDetailsTable) {
		return userDetailsDAO.createUserDetail(userDetailsTable);
	}

	public UserDetailsTable getUserDetail(Integer id) {
		return userDetailsDAO.getUserDetail(id);
	}

	public List<UserDetailsTable> getUserDetail(String parameter, String value) {
		return userDetailsDAO.getUserDetail(parameter, value);
	}

	public List<UserDetailsTable> getUserDetail() {
		return userDetailsDAO.getUserDetail();
	}

	public void updateUserDetail(UserDetailsTable userDetailsTable) {
		userDetailsDAO.updateUserDetail(userDetailsTable);
	}

	public void deleteUserDetail(UserDetailsTable userDetailsTable) {
		userDetailsDAO.deleteUserDetail(userDetailsTable);
	}


}

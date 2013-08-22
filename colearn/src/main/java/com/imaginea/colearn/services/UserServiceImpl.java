package com.imaginea.colearn.services;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.dao.UserDetailsDAO;
import com.imaginea.colearn.model.UserDetailsTable;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetailsDAO userDetailsDAO;
	
//	public Integer createUserDetail(UserDetailsTable userDetailsTable) {
//		return userDetailsDAO.createUserDetail(userDetailsTable);
//	}
//
//	public UserDetailsTable getUserDetail(Integer id) {
//		return userDetailsDAO.getUserDetail(id);
//	}
//
//	public List<UserDetailsTable> getUserDetail(String parameter, String value) {
//		return userDetailsDAO.getUserDetail(parameter, value);
//	}
//
//	public List<UserDetailsTable> getUserDetail() {
//		return userDetailsDAO.getUserDetail();
//	}
//
//	public void deleteUserDetail(UserDetailsTable userDetailsTable) {
//		userDetailsDAO.deleteUserDetail(userDetailsTable);
//	}
	
	public UserDetailsTable getUserDetail(Principal sessionName){
		if(sessionName == null){
			return null;
		}
		List<UserDetailsTable> userDetailsList = userDetailsDAO.getUserDetail("sessionName", sessionName.getName());
		
		if(!userDetailsList.isEmpty()){
			return userDetailsList.get(0);
		}
		
		return null;
	}

	public void updateUserDetail(UserDetailsTable userDetailsTable) {
		userDetailsDAO.updateUserDetail(userDetailsTable);
		
	}

	public UserDetailsTable getUserDetailsFromEmail(String email) {
		UserDetailsTable userDetailsTable;
		List<UserDetailsTable> userDetailsTables;
		userDetailsTables = userDetailsDAO.getUserDetail("emailId", email);
		
		if (userDetailsTables.size() == 0) {
			return null;//throw new UsernameNotFoundException("User is not registered with us.");
		}
		
		userDetailsTable = userDetailsTables.get(0);
		return userDetailsTable;
	}

}

package com.imaginea.colearn.services;

import java.util.List;

import com.imaginea.colearn.model.UserDetailsTable;

public interface UserService {
	public Integer createUserDetail(UserDetailsTable userDetailsTable);
	public UserDetailsTable getUserDetail(Integer id);
	public List<UserDetailsTable> getUserDetail(String parameter, String value);
	public List<UserDetailsTable> getUserDetail();
	public void updateUserDetail(UserDetailsTable userDetailsTable);
	public void deleteUserDetail(UserDetailsTable userDetailsTable);
}

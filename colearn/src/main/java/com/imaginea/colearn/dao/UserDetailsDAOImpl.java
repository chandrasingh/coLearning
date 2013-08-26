package com.imaginea.colearn.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.model.UserDetailsTable;

@Repository
public class UserDetailsDAOImpl implements UserDetailsDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Integer createUserDetail(UserDetailsTable userDetailsTable) {
		return (Integer)sessionFactory.getCurrentSession().save(userDetailsTable);
	}
	
	public UserDetailsTable getUserDetail(Integer id) {		
		return (UserDetailsTable) sessionFactory.getCurrentSession().get(UserDetailsTable.class, id);
	}
	
	public List<UserDetailsTable> getUserDetail(String parameter, String value) {
		return sessionFactory.getCurrentSession().createQuery(" from UserDetailsTable ud where ud." + parameter + " = '" +value+ "'").list();
	}
	
	public List<UserDetailsTable> getUserDetail() {
		return sessionFactory.getCurrentSession().createQuery("from UserDetails").list();
	}
	
	public void updateUserDetail(UserDetailsTable userDetailsTable) {		
		sessionFactory.getCurrentSession().update(userDetailsTable);
	}
	
	public void deleteUserDetail(UserDetailsTable userDetailsTable) {
		sessionFactory.getCurrentSession().delete(userDetailsTable);		
	}

	public void saveUserDetails(UserDetailsTable userDetailsTable) {
		sessionFactory.getCurrentSession().save(userDetailsTable);
	}

}

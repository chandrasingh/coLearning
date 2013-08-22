package com.imaginea.colearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.dao.DAOInteface;
import com.imaginea.colearn.model.UserCourseDetails;

@Service
public class UserCourseDetailsServiceImpl implements UserCourseDetailsService{

	@Autowired
	DAOInteface<UserCourseDetails, Long> userCourseDetailsDAOImpl;
	public Long saveCourse(UserCourseDetails userCourseDetails) {		
		return userCourseDetailsDAOImpl.save(userCourseDetails);
	}

}

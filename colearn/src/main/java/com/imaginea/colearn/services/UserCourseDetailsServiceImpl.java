package com.imaginea.colearn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.dao.DAOInteface;
import com.imaginea.colearn.model.UserCourseDetails;

@Service
public class UserCourseDetailsServiceImpl implements UserCourseDetailsService{

	@Autowired
	DAOInteface<UserCourseDetails, Long> userCourseDetailsDAOImpl;
	public Long saveCourse(UserCourseDetails userCourseDetails) {	
		try{
			Long courseOid = userCourseDetails.getCourseDetails().getCourseOid();
			Long userOid = userCourseDetails.getUserDetailsTable().getUserOid();
			List<String> lsQueryParamName = new ArrayList<String>();
			lsQueryParamName.add("courseDetails.courseOid");
			lsQueryParamName.add("userDetailsTable.userOid");
			List<Long> lsQueryValues = new ArrayList<Long>();
			lsQueryValues.add(courseOid);
			lsQueryValues.add(userOid);
			UserCourseDetails usrCourseDtlsFromDB = userCourseDetailsDAOImpl.getOnMultipleParams(lsQueryParamName, lsQueryValues);
			if(usrCourseDtlsFromDB == null){
				return userCourseDetailsDAOImpl.save(userCourseDetails);
			}else{
				userCourseDetails.setUserCourseDetailsOid(usrCourseDtlsFromDB.getUserCourseDetailsOid());
				userCourseDetailsDAOImpl.update(userCourseDetails);
				return usrCourseDtlsFromDB.getUserCourseDetailsOid();
			}		
		}catch(Exception exception){
			exception.printStackTrace();
		}
		return null;
	}
}

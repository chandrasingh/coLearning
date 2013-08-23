package com.imaginea.tests.base;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.dao.UserDetailsDAO;
import com.imaginea.colearn.model.CourseDetails;
import com.imaginea.colearn.model.UserCourseDetails;
import com.imaginea.colearn.model.UserDetailsTable;
import com.imaginea.colearn.services.CourseDetailsService;
import com.imaginea.colearn.services.UserCourseDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
@Ignore

public class CourseDetailsDaoTest {
	@Autowired
	CourseDetailsService courseDetailsServiceImpl;
	
	@Autowired	
	UserDetailsDAO userDtlsDao;
	UserDetailsTable emp, empRetrieved, empUpdated;
	
	@Autowired
	UserCourseDetailsService userCourseDetailsServiceImpl;
	
	@Transactional
	@Test
	public void createCourseDetailsOnService(){
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData("Data field Test CAse new");
		courseDtls.setTitle("Test Case Title new");
		courseDtls.setDescription("Test Case Description new");
		List usrList = userDtlsDao.getUserDetail("emailId", "murthy.koppu@imaginea.com");
		
		UserDetailsTable empRetrieved = (UserDetailsTable)usrList.get(0);
		
		courseDetailsServiceImpl.saveCourse(courseDtls);
		
		UserCourseDetails usrCrseDtlsEntity = new UserCourseDetails();
		usrCrseDtlsEntity.setBookmark(10);
		usrCrseDtlsEntity.setCourseDetails(courseDtls);
		usrCrseDtlsEntity.setData(courseDtls.getData());
		usrCrseDtlsEntity.setUserDetailsTable(empRetrieved);
		
		userCourseDetailsServiceImpl.saveCourse(usrCrseDtlsEntity);
	}
	
}

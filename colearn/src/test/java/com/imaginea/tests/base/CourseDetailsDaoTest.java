package com.imaginea.tests.base;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.dao.CourseDetailsDAO;
import com.imaginea.colearn.model.CourseDetails;
import com.imaginea.colearn.services.CourseDetailsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})

public class CourseDetailsDaoTest {
	@Autowired
	CourseDetailsDAO courseDtlsDao234;
	@Autowired
	CourseDetailsService courseDetailsServiceImpl;
	
	@Transactional
	@Test
	public void createCourseDetails(){
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData("Data field Test CAse");
		courseDtls.setTitle("Test Case Title");
		courseDtls.setDescription("Test Case Description");
		
		courseDtlsDao234.save(courseDtls);
	}
	
	@Transactional
	@Test
	public void createCourseDetailsOnService(){
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData("Data field Test CAse");
		courseDtls.setTitle("Test Case Title");
		courseDtls.setDescription("Test Case Description");
		
		courseDetailsServiceImpl.saveCourse(courseDtls);
	}
	
}

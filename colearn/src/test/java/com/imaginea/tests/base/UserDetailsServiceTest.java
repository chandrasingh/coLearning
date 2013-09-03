package com.imaginea.tests.base;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.dao.UserDetailsDAO;

import com.imaginea.colearn.model.UserDetailsTable;
import com.imaginea.colearn.properties.LMSConfigProperties;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:mvc-dispatcher-servlet.xml" })
@Ignore
public class UserDetailsServiceTest {
	@Autowired
	UserDetailsDAO userDtlsDao;
	UserDetailsTable emp, empRetrieved, empUpdated;
	List usrList;
	Integer empID;
	
	@Autowired
	LMSConfigProperties lmsConfigProperties;

	@Ignore
	@Transactional
	@Test
	public void getEmployeeDetailsTest()

	{
		 usrList = userDtlsDao.getUserDetail("emailId",
		 "chandings@gmail.com");
		
		 empRetrieved = (UserDetailsTable)usrList.get(0);
		 System.out.println("Object id is"+empRetrieved.getUserOid());
		 Assert.assertEquals("chandings@gmail.com",
		 empRetrieved.getEmailId());
		 
		 lmsConfigProperties.get("COURSES_UPLOAD_PATH");
		 Assert.assertEquals((Long)1l, empRetrieved.getUserOid());
	}

}

package com.imaginea.tests.base;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.imaginea.colearn.dao.UserDetailsDAO;

import com.imaginea.colearn.model.UserDetailsTable;
	


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:mvc-dispatcher-servlet.xml"})
public class UserDetailsServiceTest {
	@Autowired	
	UserDetailsDAO userDtlsDao;
	UserDetailsTable emp, empRetrieved, empUpdated;
	List usrList;
	Integer empID;
	

	@Transactional
	@Test
	public void getEmployeeDetailsTest(){
		usrList = userDtlsDao.getUserDetail("emailId", "murthy.koppu@imaginea.com");
		
		empRetrieved = (UserDetailsTable)usrList.get(0);
		System.out.println("Object id is"+empRetrieved.getUserOid());
		Assert.assertEquals("murthy.koppu@imaginea.com", empRetrieved.getEmailId());
		Assert.assertEquals((Long)1l, empRetrieved.getUserOid());
	}
	
}

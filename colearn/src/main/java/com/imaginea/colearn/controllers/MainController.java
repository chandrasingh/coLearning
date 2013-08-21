package com.imaginea.colearn.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imaginea.colearn.dao.CourseDetailsDAO;
import com.imaginea.colearn.model.CourseDetails;
import com.imaginea.colearn.services.CourseDetailsService;

@Controller
public class MainController {
	
	@Autowired
	CourseDetailsService courseDetailsServiceImpl;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("index");
		return "index";
	}
	
	@RequestMapping(value = "/CourseRegistration", method = RequestMethod.GET)
	public void courseRegistration(ModelMap model){
		System.out.println("Into server course Registration page ");
	}
	
	@Transactional
	@RequestMapping(value = "/courseRegistrationForm", method = RequestMethod.POST)
	public void courseRegistrationForm(HttpServletRequest request){
		System.out.println("Into server course Registration form ");
		
		String strCourseData = request.getParameter("courseData");
		String strCourseTitle = request.getParameter("courseTitle");
		String strCourseDescription = request.getParameter("courseDescription");
		
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData(strCourseData);
		courseDtls.setTitle(strCourseTitle);
		courseDtls.setDescription(strCourseDescription);
		
		courseDetailsServiceImpl.saveCourse(courseDtls);
		
	}
	
}

package com.imaginea.colearn.controllers;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.omg.CORBA.UserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imaginea.colearn.model.CourseDetails;
import com.imaginea.colearn.model.UserCourseDetails;
import com.imaginea.colearn.model.UserDetailsTable;
import com.imaginea.colearn.properties.LMSConfigProperties;
import com.imaginea.colearn.services.UserCourseDetailsService;
import com.imaginea.colearn.services.UserService;

import com.imaginea.colearn.services.CourseDetailsService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	CourseDetailsService courseDetailsServiceImpl;
	@Autowired
	LMSConfigProperties lmsConfigProperties;
	@Autowired
	UserCourseDetailsService userCourseDtlsServiceImpl;
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public String checkLogin(ModelMap model, Principal principal){

		UserDetailsTable userDetailsTables = userService.getUserDetail(principal);
		return null;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model, HttpServletRequest request) {
		UserDetailsTable userDetailsTables;
		List<CourseDetails> courseList = courseDetailsServiceImpl.getAllCourseDetails();
		try{
			userDetailsTables = (UserDetailsTable)request.getSession(false).getAttribute("user");
		}
		catch(NullPointerException exception){
			userDetailsTables = null;
		}
		
		if(userDetailsTables != null){
			model.addAttribute("screenName", userDetailsTables.getScreenName());
			model.addAttribute("role", userDetailsTables.getRole());
		}
		model.addAttribute("courseList", courseList);
		return "index";
	}
	
	@RequestMapping(value = "/studentRegistration", method = RequestMethod.GET)
	public String studentRegistration(ModelMap model, HttpServletRequest request ) {
		UserDetailsTable user = (UserDetailsTable)request.getSession().getAttribute("user");
		
		if(user != null){
			model.addAttribute("email", user.getEmailId());
			model.addAttribute("userRole", "ROLE_STUDENT");
			model.addAttribute("sessionName", user.getSessionName());
			model.addAttribute("role", "");
		}
		
		return "userRegistration";
	}

	@RequestMapping(value = "/author/CourseRegistration", method = RequestMethod.GET)
	public String courseRegistration(ModelMap model){
		return "CourseRegistration";
	}
	
	@RequestMapping(value = "/author/courseRegistrationForm", method = RequestMethod.POST)
	public String courseRegistrationForm(ModelMap model, HttpServletRequest request){
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>Entered intot Course Registration");
		try{
		Map<String,String> formParamData = new HashMap<String,String>();
		FileItem uploadedFileItm = null;
		
		UserDetailsTable userDetailsTables;
		
		try{
			userDetailsTables = (UserDetailsTable)request.getSession(false).getAttribute("user");
		}
		catch(NullPointerException exception){
			userDetailsTables = null;
			exception.printStackTrace();
		}
		
		if(ServletFileUpload.isMultipartContent(request)){
			try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);                
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        uploadedFileItm = item;
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>name " + name);
                    }else{
                    	formParamData.put(item.getFieldName(), item.getString());
                        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>item.getString() " + item.getString());
                    }
                }
                courseDetailsServiceImpl.registerCourseFromHTTPReq(formParamData, uploadedFileItm);
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
               ex.printStackTrace();
            }      
		}	
		
		if(userDetailsTables != null){
			model.addAttribute("role", userDetailsTables.getRole());
		}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "redirect:/index";
	}
	
	@RequestMapping(value="/studentRegistrationSubmit", method = RequestMethod.POST)
	public String studentRegistrationSubmit(@ModelAttribute("user")UserDetailsTable user, HttpServletRequest request){
		UserDetailsTable userDetails;
		userService.saveUserDetailsTable(user);
		userDetails = userService.getUserDetailsFromEmail(user.getEmailId());
		request.getSession(false).setAttribute("user", userDetails);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/registerUserToCourse", method = RequestMethod.GET)
	public void userRegistrationToCourse(HttpServletRequest request){
		HttpSession session = request.getSession(false);
		
		UserDetailsTable user = (UserDetailsTable)session.getAttribute("user");
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setCourseOid(new Long(request.getParameter("CourseOid")).longValue());
		UserCourseDetails usrCourseDtls = new UserCourseDetails();
		usrCourseDtls.setData(request.getParameter("courseDataToSave"));
		usrCourseDtls.setBookmark(request.getParameter("courseBookmark"));	
		usrCourseDtls.setUserDetailsTable(user);
		usrCourseDtls.setCourseDetails(courseDtls);
		userCourseDtlsServiceImpl.saveCourse(usrCourseDtls);
	}

}
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imaginea.colearn.model.UserDetailsTable;
import com.imaginea.colearn.services.UserService;

import com.imaginea.colearn.model.CourseDetails;
import com.imaginea.colearn.services.CourseDetailsService;

@Controller
public class MainController {

	@Autowired
	UserService userService;
	
	@Autowired
	CourseDetailsService courseDetailsServiceImpl;
	@Autowired
	LMSConfigProperties lmsConfigProperties;
	
	@RequestMapping(value = "/checkLogin", method = RequestMethod.GET)
	public String checkLogin(ModelMap model, Principal principal){

		UserDetailsTable userDetailsTables = userService.getUserDetail(principal);
		return null;
	}

	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model, Principal principal) {
		System.out.println("index");
		UserDetailsTable userDetailsTables;
		
		userDetailsTables = userService.getUserDetail(principal);
		
		if(userDetailsTables != null){
			model.addAttribute("screenName", userDetailsTables.getScreenName());
			model.addAttribute("role", userDetailsTables.getRole());
		}
		return "index";
	}

	@RequestMapping(value = "/studentRegistration", method = RequestMethod.GET)
	public String userRegisterForm(HttpServletRequest request, ModelMap model) {
		HttpSession session = request.getSession(false);
		
		UserDetailsTable user = (UserDetailsTable)session.getAttribute("user");

		model.addAttribute("email", user.getEmailId());
		model.addAttribute("sessionName", user.getSessionName());
		model.addAttribute("role", "ROLE_STUDENT");
		return "userRegistration";
	}

	@RequestMapping(value = "/CourseRegistration", method = RequestMethod.GET)
	public void courseRegistration(ModelMap model){
		System.out.println("Into server course Registration page ");
	}
	
	@Transactional
	@RequestMapping(value = "/courseRegistrationForm", method = RequestMethod.POST)
	public void courseRegistrationForm(HttpServletRequest request){
		System.out.println("Into server course Registration form ");
		Map<String,String> formParamData = new HashMap<String,String>();
		if(ServletFileUpload.isMultipartContent(request)){
			try {
                List<FileItem> multiparts = new ServletFileUpload(
                                         new DiskFileItemFactory()).parseRequest(request);                
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        item.write( new File(lmsConfigProperties.getProperty("COURSES_UPLOAD_PATH") + File.separator + name));
                    }else{
                    	formParamData.put(item.getFieldName(), item.getString());
                    }
                    
                }
           
               //File uploaded successfully
               request.setAttribute("message", "File Uploaded Successfully");
            } catch (Exception ex) {
               request.setAttribute("message", "File Upload Failed due to " + ex);
            }      


		}
		String strCourseData = formParamData.get("courseData");
		String strCourseTitle = formParamData.get("courseTitle");
		String strCourseDescription = formParamData.get("courseDescription");
		
		
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData(strCourseData);
		courseDtls.setTitle(strCourseTitle);
		courseDtls.setDescription(strCourseDescription);
		
		courseDetailsServiceImpl.saveCourse(courseDtls);
	}
	
	@RequestMapping(value="/studentRegistrationSubmit", method = RequestMethod.POST)
	public String studentRegistrationSubmit(@ModelAttribute("user")UserDetailsTable user){
		System.out.println("studentRegistrationSubmit user " + user);
		System.out.println("user.getEmailId" + user.getEmailId());
		System.out.println("user.getScreenName" + user.getScreenName());
		System.out.println("user.getSessionName" + user.getSessionName());
		System.out.println("user.getRole" + user.getRole());
		userService.saveUserDetailsTable(user);
		return "redirect:/index";
	}
}

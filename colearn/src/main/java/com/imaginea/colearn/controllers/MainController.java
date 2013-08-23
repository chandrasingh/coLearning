package com.imaginea.colearn.controllers;


import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
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
	
	@RequestMapping(value = "/student/index", method = RequestMethod.GET)
	public String stdIindex(ModelMap model, Principal principal) {
		System.out.println("index");
		UserDetailsTable userDetailsTables;
		
		userDetailsTables = userService.getUserDetail(principal);
		
		if(userDetailsTables != null){
			model.addAttribute("screenName", userDetailsTables.getScreenName());
			model.addAttribute("role", userDetailsTables.getRole());
		}
		return "index";
	}

	@RequestMapping(value = "/CourseRegistration", method = RequestMethod.GET)
	public void courseRegistration(ModelMap model){
		System.out.println("Into server course Registration page ");
	}
	
	@RequestMapping(value = "/courseRegistrationForm", method = RequestMethod.POST)
	public String courseRegistrationForm(HttpServletRequest request){
		System.out.println("Into server course Registration form ");
		Map<String,String> formParamData = new HashMap<String,String>();
		FileItem uploadedFileItm = null;
		if(ServletFileUpload.isMultipartContent(request)){
			try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);                
                for(FileItem item : multiparts){
                    if(!item.isFormField()){
                        String name = new File(item.getName()).getName();
                        uploadedFileItm = item;
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
		
		courseDetailsServiceImpl.registerCourseFromHTTPReq(formParamData, uploadedFileItm);
		return "redirect:index";
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

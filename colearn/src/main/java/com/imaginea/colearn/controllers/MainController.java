package com.imaginea.colearn.controllers;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap model) {
		System.out.println("index");
		return "index";
	}
}

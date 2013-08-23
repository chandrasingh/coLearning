package com.imaginea.colearn.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.model.UserDetailsTable;

@Service("OpenIdAuthenticationSuccessHandler")
public class OpenIdAuthenticationSuccessHandler extends
		SimpleUrlAuthenticationSuccessHandler {
	@Autowired
	UserService userService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException {
		OpenIDAuthenticationToken openIdAuthenticationToken = (OpenIDAuthenticationToken) authentication;
		List<OpenIDAttribute> attributes = openIdAuthenticationToken.getAttributes();
		HttpSession session = request.getSession(false);
		UserDetailsTable user = new UserDetailsTable();
		String email;

		user.setSessionName(openIdAuthenticationToken.getIdentityUrl());
		
		for (OpenIDAttribute attribute : attributes) {
			if (attribute.getName().equals("email")) {
				email = attribute.getValues().get(0);
				user = userService.getUserDetailsFromEmail(email);
			}
		}
		
		
		session.setAttribute("user", user);
	}
}

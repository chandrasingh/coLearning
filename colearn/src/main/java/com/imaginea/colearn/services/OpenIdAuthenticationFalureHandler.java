package com.imaginea.colearn.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationStatus;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.model.UserDetailsTable;

@Service("OpenIdAuthenticationFalureHandler")
public class OpenIdAuthenticationFalureHandler extends
		SimpleUrlAuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		System.out.println("onAuthenticationFailure");
		if (openIdAuthenticationSuccesfullButUserIsNotRegistered(exception)) {
			redirectToOpenIdRegistrationUrl(request, response, exception);
		} else {
			super.onAuthenticationFailure(request, response, exception);
		}
		//super.onAuthenticationFailure(request, response, exception);
	}
	
	private void redirectToOpenIdRegistrationUrl(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        DefaultRedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        addOpenIdAttributesToSession(request, getOpenIdAuthenticationToken(exception));
        redirectStrategy.sendRedirect(request, response, "/studentRegistration");
    }
	
	private void addOpenIdAttributesToSession(HttpServletRequest request, OpenIDAuthenticationToken openIdAuthenticationToken) throws ServletException {
		List<OpenIDAttribute> attributes = openIdAuthenticationToken.getAttributes();
		HttpSession session = request.getSession(false);
		UserDetailsTable user = new UserDetailsTable();

		user.setSessionName(openIdAuthenticationToken.getIdentityUrl());
		
		for (OpenIDAttribute attribute : attributes) {
			if (attribute.getName().equals("email")) {
				user.setEmailId(attribute.getValues().get(0));
			}
		}
		session.setAttribute("user", user);
    }

	private boolean openIdAuthenticationSuccesfullButUserIsNotRegistered(AuthenticationException exception) {
		return (exception instanceof UsernameNotFoundException &&
		exception.getAuthentication() instanceof OpenIDAuthenticationToken &&
		(OpenIDAuthenticationStatus.SUCCESS.equals((getOpenIdAuthenticationToken(exception)).getStatus())));
	}

	private OpenIDAuthenticationToken getOpenIdAuthenticationToken(AuthenticationException exception) {
		return (OpenIDAuthenticationToken) exception.getAuthentication();
	}
}

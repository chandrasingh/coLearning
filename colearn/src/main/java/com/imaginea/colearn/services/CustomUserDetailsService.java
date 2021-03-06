package com.imaginea.colearn.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.openid.OpenIDAttribute;
import org.springframework.security.openid.OpenIDAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.model.UserDetailsTable;

@Service("CustomUserDetailsService")
public class CustomUserDetailsService  implements
AuthenticationUserDetailsService, UserDetailsService {

	@Autowired
	private UserService userService;
	
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// not used
		return null;
	}

	@Transactional
	public UserDetails loadUserDetails(Authentication token)
			throws UsernameNotFoundException {
		OpenIDAuthenticationToken openidToken = (OpenIDAuthenticationToken) token;
		String identifier = openidToken.getIdentityUrl();
		String email = "";
		List<OpenIDAttribute> attributes = openidToken.getAttributes();
		
		UserDetailsTable userDetailsTable;
		
		
		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		User user;
		
		for (OpenIDAttribute attribute : attributes) {
			if (attribute.getName().equals("email")) {
				email = attribute.getValues().get(0);
			}
		}
		
		if (email.equals("")) {
			throw new UsernameNotFoundException("Unable to retrieve email id.");
		}
		
		userDetailsTable = userService.getUserDetailsFromEmail(email);
		
		if(userDetailsTable == null){
			throw new UsernameNotFoundException("User not registered with us!");
//			authorities.add(new GrantedAuthorityImpl("ROLE_ANONYMOUS"));
//			
//			user = new User(identifier, "", authorities);
//			
//			return user;
		}

		userDetailsTable.setSessionName(identifier);
		
		userService.updateUserDetail(userDetailsTable);
		
		authorities.add(new GrantedAuthorityImpl(userDetailsTable.getRole()));
		
		user = new User(identifier, "", authorities);
		
		return user;
	}

}

package com.imaginea.colearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetailsTable {
	private Long userOid;
	
	private String emailId;
	
	private String screenName;
	
	private String sessionName;
	
	private String role;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_oid", unique = true, nullable = false)
	public Long getUserOid() {
		return userOid;
	}


	public void setUserOid(Long userOid) {
		this.userOid = userOid;
	}

	
	@Column(name = "email_id", unique = true, nullable = false)
	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Column(name = "screen_name", unique = false, nullable = true)
	public String getScreenName(){
		return screenName;
	}

	public void setScreenName(String value){
		screenName = value;
	}
	
	@Column(name = "session_name", unique = false, nullable = true)
	public String getSessionName(){
		return sessionName;
	}

	public void setSessionName(String value){
		sessionName = value;
	}
	
	@Column(name = "role", unique = false, nullable = true)
	public String getRole(){
		return role;
	}

	public void setRole(String value){
		role = value;
	}
}

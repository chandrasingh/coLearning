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
	private Integer userID;
	
	private String emailID;
	
	private String screenName;
	
	private String sessionName;
	
	private String role;
	
	public UserDetailsTable(Integer userID, String emailID, String screenName, String sessionName, String role){
		this.userID = userID;
		this.emailID = emailID;
		this.screenName = screenName;
		this.sessionName = sessionName;
		this.role = role;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id", unique = true, nullable = false)
	public Integer getUserID(){
		return userID;
	}

	public void setUserID(Integer value){
		userID = value;
	}
	

	@Column(name = "email_id", unique = true, nullable = false)
	public String getEmailID(){
		return emailID;
	}

	public void setEmailID(String value){
		emailID = value;
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

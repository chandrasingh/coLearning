package com.imaginea.colearn.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UserCourseDetails {
	
	private String userCourseDetailsOid;
	private Long courseOid;
	private Long userOid;
	private String data;
	private String bookmark;
	private String userCourseMapcol;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_course_details_oid", unique = true, nullable = false)
	public String getUserCourseDetailsOid() {
		return userCourseDetailsOid;
	}
	public void setUserCourseDetailsOid(String userCourseDetailsOid) {
		this.userCourseDetailsOid = userCourseDetailsOid;
	}
	
	@Column(name = "course_oid", unique = false, nullable = false)	
	public Long getCourseOid() {
		return courseOid;
	}
	public void setCourseOid(Long courseOid) {
		this.courseOid = courseOid;
	}
	
	@Column(name = "user_oid", unique = false, nullable = false)	
	public Long getUserOid() {
		return userOid;
	}
	public void setUserOid(Long userOid) {
		this.userOid = userOid;
	}
		
	@Column(name = "data", unique = false, nullable = true)	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	@Column(name = "bookmark", unique = false, nullable = true)	
	public String getBookmark() {
		return bookmark;
	}
	public void setBookmark(String bookmark) {
		this.bookmark = bookmark;
	}
	
	@Column(name = "user_course_mapcol", unique = false, nullable = true)	
	public String getUserCourseMapcol() {
		return userCourseMapcol;
	}
	public void setUserCourseMapcol(String userCourseMapcol) {
		this.userCourseMapcol = userCourseMapcol;
	}
	
}

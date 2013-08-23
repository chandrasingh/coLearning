package com.imaginea.colearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_course_details")
public class UserCourseDetails {
	
	private Long userCourseDetailsOid;
	private CourseDetails courseDetails;
	private UserDetailsTable userDetailsTable;
	private String data;
	private String bookmark;
	private String userCourseMapcol;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_course_details_oid", unique = true, nullable = false)
	public Long getUserCourseDetailsOid() {
		return userCourseDetailsOid;
	}
	public void setUserCourseDetailsOid(Long userCourseDetailsOid) {
		this.userCourseDetailsOid = userCourseDetailsOid;
	}
	
	@ManyToOne
	@JoinColumn(name = "course_oid", unique = false, nullable = false)
	public CourseDetails getCourseDetails() {
		return courseDetails;
	}
	public void setCourseDetails(CourseDetails courseDetails) {
		this.courseDetails = courseDetails;
	}
	
	@ManyToOne
	@JoinColumn(name = "user_oid",  unique = false, nullable = false)
	public UserDetailsTable getUserDetailsTable() {
		return userDetailsTable;
	}
	public void setUserDetailsTable(UserDetailsTable userDetailsTable) {
		this.userDetailsTable = userDetailsTable;
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

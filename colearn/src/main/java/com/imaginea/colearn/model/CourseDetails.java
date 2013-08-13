package com.imaginea.colearn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course_details")
public class CourseDetails {
	private Integer courseID;
	
	private String data;
	
	private String title;
	
	private String description;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id", unique = true, nullable = false)
	public Integer getCourseID(){
		return courseID;
	}
	
	public void setCourseID(Integer value){
		courseID = value;
	}
	
	@Column(name = "data", unique = false, nullable = true)
	public String getData(){
		return data;
	}
	
	public void setData(String value){
		data = value;
	}
	
	@Column(name = "title", unique = false, nullable = false)
	public String getTitle(){
		return title;
	}
	
	public void setTitle(String value){
		title = value;
	}
	
	@Column(name = "description", unique = false, nullable = false)
	public String getDescription(){
		return description;
	}
	
	public void setDescription(String value){
		description = value;
	}
}

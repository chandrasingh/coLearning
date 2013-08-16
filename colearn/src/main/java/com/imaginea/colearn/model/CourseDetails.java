package com.imaginea.colearn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "course_details")
public class CourseDetails {
	private Long courseOid;
	
	private String data;
	
	private String title;
	
	private String description;
	
	private Date createTs;
	
	private Date modifyTs;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_oid", unique = true, nullable = false)
	public Long getCourseOid() {
		return courseOid;
	}

	public void setCourseOid(Long courseOid) {
		this.courseOid = courseOid;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_ts", unique = false,updatable = false, nullable = false)
	public Date getCreateTs() {
		return createTs;
	}

	public void setCreateTs(Date createTs) {
		this.createTs = createTs;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modify_ts", unique = false, nullable = false)
	public Date getModifyTs() {
		return modifyTs;
	}

	public void setModifyTs(Date modifyTs) {
		this.modifyTs = modifyTs;
	}
}

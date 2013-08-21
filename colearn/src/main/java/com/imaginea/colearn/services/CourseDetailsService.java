package com.imaginea.colearn.services;

import java.util.List;

import com.imaginea.colearn.model.CourseDetails;

public interface CourseDetailsService {
	public Long saveCourse(CourseDetails courseDetails);
	public CourseDetails getCourseDetail(Long id);
	public List<CourseDetails> getCourseDetails(String strParamName, String strValue);
	public List<CourseDetails> getAllCourseDetails();
	public void updateCourse(CourseDetails courseDetails);
	public void deleteCourse(CourseDetails courseDetials);
}

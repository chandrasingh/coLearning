package com.imaginea.colearn.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imaginea.colearn.dao.DAOInteface;
import com.imaginea.colearn.model.CourseDetails;

@Service
public class CourseDetailsServiceImpl implements CourseDetailsService{
	@Autowired
	DAOInteface<CourseDetails, Long> courseDetailsDAOImpl;
	
	public Long saveCourse(CourseDetails courseDetails) {
		courseDetails.setCreateTs(new Date());
		courseDetails.setModifyTs(new Date());
		return courseDetailsDAOImpl.save(courseDetails);
	}

	public CourseDetails getCourseDetail(Long id) {
		return courseDetailsDAOImpl.getOnPk(id);
	}

	public List<CourseDetails> getCourseDetails(String strParamName,
			String strValue) {
		return courseDetailsDAOImpl.getAsLsOnPk(strParamName, strValue);
	}

	public List<CourseDetails> getAllCourseDetails() {
		return courseDetailsDAOImpl.getAllAsLs();
	}

	public void updateCourse(CourseDetails courseDetails) {
		courseDetailsDAOImpl.update(courseDetails);
	}

	public void deleteCourse(CourseDetails courseDetials) {
		courseDetailsDAOImpl.delete(courseDetials);
	}
	
}

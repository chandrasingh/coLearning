package com.imaginea.colearn.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.imaginea.colearn.model.CourseDetails;

@Repository(value="courseDtlsDao234")
public class CourseDetailsDAOImpl extends DAOInterfaceImpl<CourseDetails, Long> implements CourseDetailsDAO{
	public CourseDetailsDAOImpl() {
		super.entityName = "CourseDetails";
	}

	@Override
	public Long save(CourseDetails newEntity) {
		newEntity.setCreateTs(new Date());
		newEntity.setModifyTs(new Date());
		return super.save(newEntity);
	}
	
}

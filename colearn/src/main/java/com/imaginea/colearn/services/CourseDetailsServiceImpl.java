package com.imaginea.colearn.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.fileupload.FileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imaginea.colearn.controllers.LMSConfigProperties;
import com.imaginea.colearn.dao.DAOInteface;
import com.imaginea.colearn.model.CourseDetails;

@Service
public class CourseDetailsServiceImpl implements CourseDetailsService{
	@Autowired
	DAOInteface<CourseDetails, Long> courseDetailsDAOImpl;
	
	@Autowired
	LMSConfigProperties lmsConfigProperties;
	
	public Long saveCourse(CourseDetails courseDetails) {
		courseDetails.setCreateTs(new Date());
		courseDetails.setModifyTs(new Date());
		return courseDetailsDAOImpl.save(courseDetails);
	}
	
	@Transactional
	public void registerCourseFromHTTPReq(Map<String, String> formParamData,
			FileItem uploadedFileItm) {
		
		CourseDetails courseDtls = new CourseDetails();
		courseDtls.setData(formParamData.get("courseData"));
		courseDtls.setTitle(formParamData.get("courseTitle"));
		courseDtls.setDescription(formParamData.get("courseDescription"));
		
		Long courseOidInCrse = this.saveCourse(courseDtls);	
		
		try {
			
			File newUnZippedRootOPFldr = persistUploadFileToCoursesRepos(
					uploadedFileItm, courseOidInCrse);
			copyCoursesReposToDeployLoc(courseOidInCrse, newUnZippedRootOPFldr);
				
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			
		}
	}

	private void copyCoursesReposToDeployLoc(Long courseOidInCrse,
			File newUnZippedRootOPFldr) throws IOException {
		File courseDplyFldr = new File(lmsConfigProperties.getProperty("COURSES_FOLDER_DEPLOY_PATH")+File.separator+courseOidInCrse);
		
		copyFolder(newUnZippedRootOPFldr, courseDplyFldr);
	}

	private File persistUploadFileToCoursesRepos(FileItem uploadedFileItm,
			Long courseOidInCrse) throws IOException, FileNotFoundException {
		File uploadedFile = new File(uploadedFileItm.getName());
		String strUploadedFileName = uploadedFile.getName();
		File newUnZippedRootOPFldr = new File(lmsConfigProperties.getProperty("COURSES_UPLOAD_PATH")+File.separator+courseOidInCrse);
		newUnZippedRootOPFldr.mkdir();
		int len;
		byte[] buffer = new byte[1024];
		FileOutputStream newOPFos = null;
		InputStream uploadedFileIStream = uploadedFileItm.getInputStream();
		if(!strUploadedFileName.endsWith("zip")){
			File newOPFile = new File(newUnZippedRootOPFldr+File.separator+uploadedFileItm.getName());
			newOPFos = new FileOutputStream(newOPFile);             					 
			while ((len = uploadedFileIStream.read(buffer)) > 0) {
		    	newOPFos.write(buffer, 0, len);
		    }
			newOPFos.flush();
			newOPFos.close();
		}else{				
			ZipInputStream zipFileis = new ZipInputStream(uploadedFileIStream);
			ZipEntry zipFileEntry = zipFileis.getNextEntry();			
			while(zipFileEntry != null){
				File newOPFile = new File(newUnZippedRootOPFldr+File.separator+zipFileEntry.getName());
				new File(newOPFile.getParent()).mkdirs();
				newOPFos = new FileOutputStream(newOPFile);
		        while ((len = zipFileis.read(buffer)) > 0) {
		        	newOPFos.write(buffer, 0, len);
		        }
		        zipFileEntry =  zipFileis.getNextEntry();
		        newOPFos.flush();
		        newOPFos.close();
			}
			zipFileis.closeEntry();
			zipFileis.close();
		}
		return newUnZippedRootOPFldr;
	}
	
	private void copyFolder(File srcFile, File destFile) throws IOException{
		if(srcFile.isDirectory()){
			String[] srcFiles = srcFile.list();
			destFile.mkdir();
			for(String srcEleFileName: srcFiles){
				File srcEleFile = new File(srcFile,srcEleFileName);
				File opDeplyEleFile = new File(destFile,srcEleFileName);
				copyFolder(srcEleFile, opDeplyEleFile);
			}
			
		}else{
			InputStream inSrcFile = new FileInputStream(srcFile);
			OutputStream outDestFile = new FileOutputStream(destFile);
			
			byte[] buffer = new byte[1024];
			 
 	        int length;
 	        //copy the file content in bytes 
 	        while ((length = inSrcFile.read(buffer)) > 0){
 	        	outDestFile.write(buffer, 0, length);
 	        }
			inSrcFile.close();
			outDestFile.flush();
			outDestFile.close();			
		}
			
		
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

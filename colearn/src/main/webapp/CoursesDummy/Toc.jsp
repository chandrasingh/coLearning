<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TOC of Course</title>
<script type="text/javascript">
	function callUsrCourseRegis(){
		try{
			var currentUrl = document.URL;/* 
			alert("currentUrl is"+currentUrl); */
			var ixCourseOid = currentUrl.indexOf("registeredCourseOid=")+20;
			var ixEndCourseOid = currentUrl.substring(ixCourseOid).indexOf('&');
			var courseOidArg;
			if(ixEndCourseOid === -1){
				courseOidArg = currentUrl.substring(ixCourseOid);
			}else{
				courseOidArg = currentUrl.substring(ixCourseOid,ixEndCourseOid - ixCourseOid);
			}/* 
			alert("courseOid is "+courseOidArg); */
			 var url = '/colearn/registerUserToCourse';
			 $.ajax({
		            type: "GET",
		            url: url,
		            data: {CourseOid: courseOidArg, 
		            	courseDataToSave: "You are in Table of Contents Page", 
		            	courseBookmark: "Toc.jsp"},
		            dataType: "html"
		      });
		}catch(err){
			alert("Error description: " + err.message);
		}
		
	}
</script>
</head>
<body>
<script src="<c:url value='jquery.min.js' />"></script>
<script>callUsrCourseRegis();</script>
	<div>
		<ul>
			<li> <a href="Home.jsp"> HTML HOME</a> </li>
			<li> <a href="Description.jsp"> HTML Description</a> </li>
			<li> <a> HTML Editors</a> </li>
			<li> <a> HTML Basic</a> </li>
			<li> <a> HTML Elements</a> </li>
			<li> <a> HTML Attributes</a> </li>
		</ul>
	</div>
</body>
</html>
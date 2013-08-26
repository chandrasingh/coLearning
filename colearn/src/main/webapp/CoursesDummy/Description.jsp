<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HTML Description Page</title>
<script type="text/javascript">
	function callUsrCourseRegis(){
		try{
			var currentUrl = document.URL;
			/* alert("currentUrl is"+currentUrl); */
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
		            	courseDataToSave: "You are in Description Page", 
		            	courseBookmark: "Description.jsp"},
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
<ul>
		<li>HTML stands for <b>H</b>yper <b>T</b>ext <b>M</b>arkup <b>L</b>anguage
		</li>
		<li>HTML is a <b>markup </b>language
		</li>
		<li>A markup language is a set of markup<b> tags</b></li>
		<li>The tags <b>describe</b> document content
		</li>
		<li>HTML documents contain<b> </b> HTML<b> tags</b> and plain <b>text</b></li>
		<li>HTML documents are also called<b> web pages</b></li>
	</ul>
</body>
</html>
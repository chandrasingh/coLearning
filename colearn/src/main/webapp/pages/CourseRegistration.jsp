<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Course Registration</title>
<%@ page isELIgnored="false"%>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
<script type='text/javascript'>
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="#"><spring:message code="label.title" /></a>
			<div class="nav pull-right">
				<div class="dropdown">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						Action <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="?lang=en"><spring:message
									code="label.language.english" /></a></li>
						<li><a href="?lang=fn"><spring:message
									code="label.language.french" /></a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	
	<form method="post" action="courseRegistrationForm" name="courseRegistrationForm" >
		<table>
			<tr>
				<td>
					<spring:message code="label.course.form.data" />
				</td>
				<td>
					<input type="text" name="courseData" id="courseData" />
				</td>				
			</tr>
			<tr>
				<td>
					<spring:message code="label.course.form.title" />
				</td>
				<td>
					<input type="text" name="courseTitle" id="courseTitle" />
				</td>
			</tr>
			<tr>
				<td>
					<spring:message code="label.course.form.description" />
				</td>
				<td>
					<input type="text" name="courseDescription" id="courseDescription" />
				</td>
			</tr>
		</table>
		
		<tr>
			<td colspan="2">            
				<input type="submit" value="Add" />         
			</td>
		</tr>
		
	</form>		
	
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	
		
</body>
</html>
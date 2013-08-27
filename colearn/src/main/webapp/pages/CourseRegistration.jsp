<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Course Registration</title>
<%@ page isELIgnored="false"%>
<link href="<c:url value='/resources/css/bootstrap.css' />"
	rel="stylesheet" />
<link href="<c:url value='/resources/css/bootstrap-responsive.css' />"
	rel="stylesheet" />
<script type='text/javascript'>
	
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="#"><spring:message code="label.title" /></a>
			<ul class="nav">
				<li><a href="<c:url value='index' />"><spring:message
							code="label.home" /></a></li>
				<c:choose>
					<c:when test="${role == 'ROLE_STUDENT'}">
						<li><a href="#"><spring:message code="label.my.courses" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_AUTHOR'}">
						<li><a href="CourseRegistration"><spring:message
									code="label.create.course" /></a></li>
						<li><a href="#"><spring:message code="label.my.courses" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_ADMIN'}">

					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
			</ul>
			<div class="nav pull-right">
				<div class="dropdown">
					<button class="btn dropdown-toggle" data-toggle="dropdown">
						<spring:message code="label.language" />
						<span class="caret"></span>
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
	<form class="form-horizontal" action="courseRegistrationForm" method="post" enctype="multipart/form-data">
		<div class="control-group">
			<label class="control-label" for="courseTitle"><spring:message
					code="label.course.form.title" /></label>
			<div class="controls">
				<input type="text" name="courseTitle" id="courseTitle"
					placeholder="Course Title" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="courseData"><spring:message
					code="label.course.form.data" /></label>
			<div class="controls">
				<input type="text" name="courseData" id="courseData"
					placeholder="Course Data" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="courseDescription"><spring:message
					code="label.course.form.description" /></label>
			<div class="controls">
				<input type="text" name="courseDescription" id="courseDescription"
					placeholder="Course Description" />
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" for="uploaded"><spring:message
					code="label.course.form.filepath" /></label>
			<div class="controls">
				<input type="file" name="uploaded" id="uploaded" />
			</div>
				<button type="submit" class="btn">
					Add
				</button>
		</div>
	</form>
	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>
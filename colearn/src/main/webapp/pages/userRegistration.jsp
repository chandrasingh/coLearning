<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title><spring:message code="label.title" /></title>
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
						<li><a href="#"><spring:message
									code="label.my.courses" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_AUTHOR'}">
						<li><a href="CourseRegistration"><spring:message
									code="label.create.course" /></a></li>
						<li><a href="#"><spring:message
									code="label.my.courses" /></a></li>
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


	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<p class="lead">
					<c:choose>
						<c:when test="${userRole == 'ROLE_STUDENT'}">
							<spring:message code="label.student.registration.message" />
						</c:when>

						<c:when test="${userRole == 'ROLE_AUTHOR'}">
							<spring:message code="label.author.registration.message" />
						</c:when>

						<c:when test="${userRole == 'ROLE_ADMIN'}">
							<spring:message code="label.admin.registration.message" />
						</c:when>
						<c:otherwise>

						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>

	<form class="form-horizontal" action="studentRegistrationSubmit"
		method="post">
		<div class="control-group">
			<label class="control-label" for="screenName"><spring:message
					code="label.screen.name" /></label>
			<div class="controls">
				<input type="text" id="screenName" name="screenName"
					placeholder="Screen Name"> <input type="hidden"
					id="emailId" name="emailId" value="${email}"> <input
					type="hidden" id="role" name="role" value="${userRole}"> <input
					type="hidden" id="sessionName" name="sessionName"
					value="${sessionName}">
			</div>
			<button type="submit" class="btn">
				<spring:message code="label.add.me" />
			</button>
		</div>
	</form>
	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>
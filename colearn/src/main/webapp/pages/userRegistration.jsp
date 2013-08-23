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
	<p class="lead">
		<c:choose>
			<c:when test="${role == 'ROLE_STUDENT'}">
						<spring:message code="label.student.registration.message" />
					</c:when>

			<c:when test="${role == 'ROLE_AUTHOR'}">
						<spring:message code="label.author.registration.message" />
					</c:when>

			<c:when test="${role == 'ROLE_ADMIN'}">
						<spring:message code="label.admin.registration.message" />
					</c:when>
			<c:otherwise>

			</c:otherwise>
		</c:choose>
	</p>
	<form class="form-horizontal" action="studentRegistrationSubmit"
		method="post">
		<div class="control-group">
			<label class="control-label" for="screenName"><spring:message code="label.screen.name"/></label>
			<div class="controls">
				<input type="text" id="screenName" name="screenName" placeholder="Screen Name">
				<input type="hidden" id="emailId" name="emailId" value="${email}"> 
				<input type="hidden" id="role" name="role" value="${role}">
				<input type="hidden" id="sessionName" name="sessionName" value="${sessionName}">
			</div>
			<button type="submit" class="btn"><spring:message code="label.add.me"/></button>
		</div>
	</form>
	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>
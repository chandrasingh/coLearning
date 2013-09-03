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
				<li class="active"><a href="#"><spring:message
							code="label.home" /></a></li>
				<c:choose>
					<c:when test="${role == 'ROLE_STUDENT'}">
						<li><a href="#"><spring:message code="label.my.courses" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_AUTHOR'}">
						<li><a href="author/CourseRegistration"><spring:message
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
				<c:choose>
					<c:when test="${empty role}">
						<a class="brand" href="<c:url value='login' />"><spring:message
								code="label.login" /></a>
					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
			</div>
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
			<div class="span6">
				<div class="hero-unit">
					<h2>
						<spring:message code="label.about.title" />
					</h2>
					<p>
						<spring:message code="label.about.body" />
					</p>
				</div>
			</div>
			<div class="span6">
				<h2>
					<spring:message code="label.courses" />
				</h2>
				<c:choose>
					<c:when test="${empty courseList}">
						<p class="lead">
							<spring:message code="label.noCourseFoundMessage" />
						</p>
					</c:when>
					<c:otherwise>
						<div class="accordion" id="accordion2">
							<c:set var="count" value="${0}" />
							<c:forEach items="${courseList}" var="course">
								<div class="accordion-group">
									<div class="accordion-heading">
										<a class="accordion-toggle" data-toggle="collapse"
											data-parent="#accordion2" href="#collapse${count}">
											${course.getTitle()}</a>
									</div>
									<div id="collapse${count}" class="accordion-body collapse">
										<div class="accordion-inner">
											<div class="row">
												<div class="span3 offset1">Description</div>
												<div class="span8">${course.getDescription()}</div>
											</div>
											<div class="row">
												<div class="span3 offset1">Created On</div>
												<div class="span8">${course.getCreateTs()}</div>
											</div>
											<div class="row">
												<div class="span11 offset1">
													<a
														href="resources/${course.getCourseOid()}/Toc.jsp?registeredCourseOid=${course.getCourseOid()}"
														target="_blank" class="text-center"><b>Content</b></a>
												</div>
											</div>
										</div>
									</div>
								</div>
								<c:set var="count" value="${count+1}" />
							</c:forEach>
						</div>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>

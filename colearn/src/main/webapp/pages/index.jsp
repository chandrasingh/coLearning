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
	function init() {
		alert(${role});
	}
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body onload="init()">
	<div class="navbar">
		<div class="navbar-inner">
			<a class="brand" href="#"><spring:message code="label.title" /></a>
			<ul class="nav">
				<li class="active"><a href="#"><spring:message
							code="label.home" /></a></li>
				<c:choose>
					<c:when test="${role == 'ROLE_STUDENT'}">
						<li><a class="brand" href="#"><spring:message
									code="label.my.cources" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_AUTHOR'}">
						<li><a class="brand" href="#"><spring:message
									code="label.create.course" /></a></li>
						<li><a class="brand" href="#"><spring:message
									code="label.my.courses" /></a></li>
					</c:when>

					<c:when test="${role == 'ROLE_ADMIN'}">

					</c:when>
					<c:otherwise>

					</c:otherwise>
				</c:choose>
			</ul>
			<div>
				<c:choose>
					<c:when test="${empty role}">
						<a class="brand" href="<c:url value='login' />"><spring:message
								code="label.login" /></a>
						<a class="brand" href="<c:url value='studentRegisterForm' />"><spring:message
								code="label.register" /></a>
					</c:when>
					<c:otherwise>
						<a class="brand" href="<c:url value='logout' />"><spring:message
								code="label.logout" /></a>
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
				<spring:message code="label.about.title" />
			</div>
			<div class="span6">1</div>
		</div>
	</div>
	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<%@ page isELIgnored="false"%>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<link href="resources/css/bootstrap-responsive.css" rel="stylesheet">
<script type='text/javascript'>
	
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body onload='document.f.j_username.focus();'>
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
	<c:if test="${not empty error}">
		<div class="errorblock">
			Your login attempt was not successful, try again.<br /> Caused :
			${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	<div class="hero-unit">
		<h3>Use your Google account to login.</h3>
		<p>
		<form action="j_spring_openid_security_check" method="post">
			<fieldset>
				<input name="openid_identifier" type="hidden"
					value="https://www.google.com/accounts/o8/id" />
				<button type="submit" class="btn btn-primary">Login</button>
			</fieldset>
		</form>
		</p>
	</div>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
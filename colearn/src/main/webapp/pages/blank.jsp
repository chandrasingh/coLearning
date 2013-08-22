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

	<script src="<c:url value='resources/js/jquery.min.js' />"></script>
	<script src="<c:url value='resources/js/bootstrap.min.js' />"></script>
</body>
</html>

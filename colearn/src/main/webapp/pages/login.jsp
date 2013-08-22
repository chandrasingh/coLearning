<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<input name="openid_identifier" type="hidden" value="https://www.google.com/accounts/o8/id" />
			<button type="submit" class="btn btn-primary">Login</button>
		</fieldset>
	</form>
  </p>
</div>
	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
</body>
</html>
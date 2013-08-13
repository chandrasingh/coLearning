<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Login Page</title>
<%@ page isELIgnored="false"%>
<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap.css" rel="stylesheet">
<link href="http://twitter.github.io/bootstrap/assets/css/bootstrap-responsive.css" rel="stylesheet">

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
<!-- 		<img src="resources/google-logo.png"></img> -->
	
<!-- 	<form action="j_spring_openid_security_check" method="post"> -->
<!-- 		For Google users: <input name="openid_identifier" type="hidden" -->
<!-- 			value="https://www.google.com/accounts/o8/id" /> <input type="submit" -->
<!-- 			value="Sign with Google" /> -->
<!-- 	</form> -->
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="http://twitter.github.io/bootstrap/assets/js/bootstrap.min.js"></script>
</body>
</html>
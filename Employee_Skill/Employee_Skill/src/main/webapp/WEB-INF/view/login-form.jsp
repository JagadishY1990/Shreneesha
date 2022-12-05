<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Skill Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="../WebContent/empskill.js"></script>
</head>
<body>
   <header>
		<nav class="navbar navbar-expand-md navbar-dark"
			 style="background-color: blue">
			<div>
				<a href="#" class="navbar-brand"> Bosch Employee Skill Application </a>
			</div>

		</nav>
	</header>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="/loginSubmit" method="post">
				<c:if test="${loginDetails != null && loginDetails.status == 'FAILURE'}">
			     <p>Enter/Select Valid User Details</p>
				</c:if>
				<label for="uname"><b>Username</b></label><br/><br/>
				<input type="text" placeholder="Enter Username" name="uname" required>
				<label for="psw"><b>Password</b></label><br/><br/>
				<input type="password" placeholder="Enter Password" name="psw" required>
				<label for="User Role"><b>User Role</b></label><br/><br/>
				 <select name="role" required>
					<option value="" selected>Select...</option>
					<option value="ADMIN">Admin</option>
					<option value="EMPLOYEE">Employee</option>
				  </select><br/><br/>
				<button type="submit" class="btn btn-success" align="center">Login</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>
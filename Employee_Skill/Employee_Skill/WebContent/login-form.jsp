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
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
			<form action="insert" method="post">
				<label for="uname"><b>Username</b></label>
				<input type="text" placeholder="Enter Username" name="uname" required>
				<label for="psw"><b>Password</b></label>
				<input type="password" placeholder="Enter Password" name="psw" required>
				<label for="psw"><b>User Role</b></label>
				 <select>
					<option selected>Select...</option>
					<option value="1">Admin</option>
					<option value="2">Employee</option>
				  </select>
				<button type="submit" class="btn btn-success">Login</button>
			</form>
			</div>
		</div>
	</div>
</body>
</html>
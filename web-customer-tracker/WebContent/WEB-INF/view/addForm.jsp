<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Customer</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
</head>
<body>
	<div class="container">
		<br>
		<h1 class="display-4 text-primary font-weight-normal">CRM -
			Customer Relationship Manager</h1>
		<br>
		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">
			<form:hidden path="id"/>
			<div class="form-group">
				<label>First Name : </label>
				<form:input class="form-control" path="firstName" />
			</div>
			<div class="form-group">
				<label>Last Name : </label>
				<form:input class="form-control" path="lastName" />
			</div>
			<div class="form-group">
				<label>Email :</label>
				<form:input class="form-control" path="email" />
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form:form>
		<br>
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to list</a>
		</p>
	</div>
</body>
</html>
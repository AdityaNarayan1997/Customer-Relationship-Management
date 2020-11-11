<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<br>
	<div class="container">
		<h1 class="display-4 text-primary font-weight-normal">CRM -
			Customer Relationship Manager</h1>
		<br>
		<div class="container">
			<button type="button" class="btn btn-outline-secondary"
				onclick="window.location.href='addForm';return false;">Add
				Customers</button>
		</div>
		<br>
		<table class="table table-striped">
			<thead>
				<tr class="table-danger">
					<th scope="col">First Name</th>
					<th scope="col">Last Name</th>
					<th scope="col">Email</th>
					<th scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tempCustomer" items="${customers}">
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<tr class="table-warning">
						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</body>
</html>
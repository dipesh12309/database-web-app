<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Customers</title>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<!-- Add a button Add Customer -->


			<form action="${pageContext.request.contextPath}/customer/showAddForm">
				<input type="submit" value="Add Customer">
			</form>
			<table>

				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- loop through the customers with JSTL core tags -->
				<c:forEach var="temp" items="${customers}">

					<!-- add an update link for each customer -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">

						<c:param name="cid" value="${temp.id}"></c:param>

					</c:url>
					<!-- add a delete link for each customer -->
					<c:url var="deleteLink" value="/customer/delete">

						<c:param name="cid" value="${temp.id}"></c:param>

					</c:url>
					<tr>
						<td>${temp.firstName}</td>
						<td>${temp.lastName}</td>
						<td>${temp.email}</td>
						<!-- adding an update link for each row -->
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer ?'))) return false"
							>Delete</a>
						</td>
					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
</body>
</html>
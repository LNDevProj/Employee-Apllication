<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display Employee Details</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<c:choose>

		<c:when test="${msg.getClass().getSimpleName().equals(\"String\") }">
			<h2>${ msg }</h2>
		</c:when>
		<c:when
			test="${msg.getClass().getSimpleName().equals(\"EmployeeDto\") }">
			<table border="1" align="center">
				<tr>
					<th>Emp-Number</th>
					<th>Emp-Name</th>
					<th>Emp-Email</th>
					<th>Emp-Age</th>
					<th>Emp-DOB</th>
					<th>Emp-Salary</th>
					<th>Emp-Status</th>
				</tr>
				<tr>
					<td>${msg.empNumber}</td>
					<td>${msg.empName}</td>
					<td>${msg.empEmail}</td>
					<td>${msg.empAge}</td>
					<td>${msg.empDateOfBirth}</td>
					<td>${msg.empSalary}</td>
					<c:choose>

						<c:when test="${msg.empStatus==true}">
							<td>Active</td>
						</c:when>

						<c:otherwise>
							<td>InActive</td>
						</c:otherwise>
					</c:choose>

				</tr>
			</table>

		</c:when>

	</c:choose>
</body>
</html>
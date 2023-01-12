<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All the Employees</title>
</head>
<body>

	<jsp:include page="index.jsp"></jsp:include>

	<h1>All Employee Details</h1>

	<table border="1" align="center">
		<tr>
			<th>Emp-Number</th>
			<th>Emp-Name</th>
			<th>Emp-Email</th>
			<th>Emp-Age</th>
			<th>Emp-DOB</th>
			<th>Emp-Salary</th>
			<th>Emp-Status</th>
			<th colspan="2">Actions</th>
		</tr>

		<c:forEach var="empdet" items="${ employees }">
			<tr>
				<td>${empdet.empNumber}</td>
				<td>${empdet.empName}</td>
				<td>${empdet.empEmail}</td>
				<td>${empdet.empAge}</td>
				<td>${empdet.empDateOfBirth}</td>
				<td>${empdet.empSalary}</td>
				<c:choose>
					<c:when test="${empdet.empStatus==true}">
						<td>Active</td>
					</c:when>
					<c:otherwise>
						<td>Inactive</td>
					</c:otherwise>
					
					<%-- <c:when test="${empdet.empStatus==false}">
						
					</c:when> --%>
				</c:choose>
				<td><a href='./edit/${empdet.empNumber }'>EDIT</a></td>
				<td><a href='./delete?empNumber=${empdet.empNumber }'>DELETE</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
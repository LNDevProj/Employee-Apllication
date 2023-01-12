<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Employee Details</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<h1>Editing Page</h1>
	<div class="container">
		<form action="/emp-apps/update-employee" method="POST">

			<label>Employee Number : </label> <input type="text" name="empNumber"
				value="${employee.empNumber }" readonly="readonly"> <br>
			<br> <label>Employee Name : </label> <input type="text"
				name="empName" value="${employee.empName }"> <br> <br>

			<label>Employee Email : </label> <input type="email" name="empEmail"
				value="${employee.empEmail }"> <br> <br> <label>Employee
				DOB : </label> <input type="date" name="empDateOfBirth"
				value="${employee.empDateOfBirth}"> <br> <br> <label>Employee
				Salary : </label> <input type="number" name="empSalary"
				value="${employee.empSalary }"> <br> <br> 
				<label>EmployeeStatus : </label>

			<c:choose>

				<c:when test="${employee.empStatus==true }">
					<label for="active">Active</label><input type="radio" name="empStatus" value=true id="active" checked='checked'>
					<label for="inactive">InActive</label><input type="radio" name="empStatus" value=false id="inactive">
				</c:when>

				<c:when test="${employee.empStatus==false}">
					<label for="active">Active</label>
					<input type="radio" name=empStatus value=true  id="active">

					<label for="inactive">InActive</label>
					<input type="radio" name=empStatus value=false id="inactive" checked='checked'>
				</c:when>


			</c:choose>
			<br> <br> <input type="submit" value="UPDATE">
		</form>

	</div>

</body>
</html>
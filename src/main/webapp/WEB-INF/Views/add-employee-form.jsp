<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>
<div class="container">
<form action="employees" method="post">

<label>Employee Name : </label><input type="text" name="empName">
<br><br>

<label>Employee Email : </label><input type="email" name="empEmail">
<br><br>

<label>Employee DOB : </label><input type="date" name="empDateOfBirth">
<br><br>

<label>Employee Salary : </label><input type="number" name="empSalary">
<br><br>

<label>Employee Status : </label>
<br><br>
<label for="active"> Active   </label>
<input type="radio" name="empStatus" value=true id = "active">

<label for="inactive"> InActive   </label>
<input type="radio" name="empStatus" value=false id = "inactive">
<br><br>

<input type="submit" value="ADD EMPLOYEES">
</form>
</div>
</body>
</html>
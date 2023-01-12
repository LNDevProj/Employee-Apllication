<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>
	<jsp:include page="index.jsp"></jsp:include>
	<div class="container">

		<form action="search-employees">
			<label>Employee Number : </label> <br> <input type="text" name="empNumber"> 
			<br><br> 
			
			<input type="submit" value="SEARCH">

		</form>

	</div>

</body>
</html>
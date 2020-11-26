<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Student</title>
</head>
<body>
	<form action="AddStudentServlet" method="post">
		Student Name: <input type="text" name="stdName"><br/><br/>
		Student ID: <input type="text" name="stdid"><br/><br/>
		Student Age: <input type="text" name="stdAge"><br/><br/>
		 <input type="submit" value="Add">
	</form>
</body>
</html>
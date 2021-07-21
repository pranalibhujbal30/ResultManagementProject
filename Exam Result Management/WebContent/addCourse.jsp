<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="centre">
<h1>User Login</h1>
<form action="AddCourse" method="post">
<table>
<tr><td>Course ID: </td><td><input type="text" name="course_id"></td></tr>
<tr><td>Name: </td><td><input type="text" name="name"></td></tr>
<tr><td>Type: </td><td><input type="text" name="type"></td></tr>
<tr><td>Semester: </td><td><input type="text" name="sem"></td></tr>
<tr><td>Credits: </td><td><input type="text" name="credits"></td></tr>
<tr><td></td><td><input type="submit" value="ADD"></td></tr>
 </table>
</form></div>
</body>
</html>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div>

<form action="AddStudent" method="post" enctype="multipart/form-data">

<tr><td>Choose a File: </td><td><input type="file" name="file_upload"></td></tr>

<tr><td></td><td><input type="submit" value="Upload"></td></tr>
</form>

</div>
</body>
</html>
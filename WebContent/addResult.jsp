<%@page import="com.dao.ResultImplDAO"%>

<%@page import="com.pojo.Result"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insert Result</h1>
<div>


<form action="AddResult" method="post" enctype="multipart/form-data">
<tr><td>Semester: </td><td><input type="text" name="semester"></td></tr>
<tr><td>Examination: </td><td><input type="text" name="exam_type"></td></tr>
<tr><td>Course Id: </td><td><input type="text" name="course_id"></td></tr>
<tr><td>Choose a File: </td><td><input type="file" name="file_upload"></td></tr>

<tr><td></td><td><input type="submit" value="Upload"></td></tr>
</form>

</div>

</body>
</html>
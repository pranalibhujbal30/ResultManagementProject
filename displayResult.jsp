<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.Course2"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.ResultDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="DisplayResult" method="post">
<label>CNo</label>
<input type="text" name="CNo">
<label for="semester">choose a semester</label>
<select name="semester" id="semester">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
</select>
<input type="submit" value="Show">
</form>


</body>
</html>
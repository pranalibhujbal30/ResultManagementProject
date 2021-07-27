<%@page import="java.util.ArrayList"%>
<%@page import="com.pojo.Course2"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Course2> courses = new ArrayList<>();
courses=(List<Course2>)request.getAttribute("courses");
float sgpa=(float)request.getAttribute("sgpa");
%>
<table border="1">
<tr bgcolor="00FF7F">
<th><b>Course_id</b></th>
<th><b>Total</b></th>
<th><b>Grade</b></th>
</tr>
<%for(int i=0;i<courses.size();i++)
	{%>
<tr>
<td><%=courses.get(i).getCourse_id() %></td>
<td><%=courses.get(i).getTotal_marks()%></td>
<td><%=courses.get(i).getGrade()%></td>
</tr>
<%} %>
<tr>
<td>SGPA </td>
<td><%=sgpa %></td>
</table>
</body>
</html>
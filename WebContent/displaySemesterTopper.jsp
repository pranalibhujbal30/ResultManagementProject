<%@page import="com.dao.ResultDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Semester Topper</h1>
<table border="1">
<tr bgcolor="00FF7F">
<th><b>CNo</b></th>
<th><b>Name</b></th>
<th><b>Division</b></th>
<th><b>Semester</b></th>
<th><b>SGPA</b></th>
</tr>
<tr>
<td><%=request.getAttribute("CNo") %></td>
<td><%=request.getAttribute("name") %></td>
<td><%=request.getAttribute("division") %></td>
<td><%=request.getAttribute("semester")%></td>
<td><%=request.getAttribute("sgpa")%></td>
</tr>
</table>

</body>
</html>
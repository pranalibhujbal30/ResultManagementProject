<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr bgcolor="00FF7F">
<th><b>CNo</b></th>
<th><b>Name</b></th>
<th><b>Division</b></th>
<th><b>Course ID</b></th>
<th><b>Total</b></th>
</tr>
<tr>
<td><%=request.getAttribute("CNo") %></td>
<td><%=request.getAttribute("name") %></td>
<td><%=request.getAttribute("division") %></td>
<td><%=request.getAttribute("course_id") %></td>
<td><%=request.getAttribute("Total_marks")%></td>
</tr>
</table>
</body>
</html>
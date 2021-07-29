<%@page import="com.pojo.Sgpa"%>
<%@page import="java.util.List"%>
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
<table border="1">
	<tr bgcolor="00FF7F">
<th><b>CNo</b></th>
<th><b>Name</b></th>
<th><b>Division</b></th>
<th><b>Semester</b></th>
<th><b>SGPA</b></th>

</tr>
<% List<Sgpa> sgpa=new ArrayList<>();
try{
sgpa=(List<Sgpa>)request.getAttribute("sgpa");
for(int i=0;i<sgpa.size();i++)
	{%>
<tr>
<td><%=sgpa.get(i).getCNo() %></td>
<td><%=sgpa.get(i).getName() %></td>
<td><%=sgpa.get(i).getDivision()%></td>
<td><%=sgpa.get(i).getSemester() %></td>
<td><%=sgpa.get(i).getSgpa()%></td>

<%}}catch(Exception e)
{}
%>
	</table>

</body>
</html>
<%@page import="com.dao.ResultImplDAO"%>
<%@page import="com.pojo.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CourseDAOImpl"%>
<%@page import="com.dao.CourseDAO"%>

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
		CourseDAO dao = new CourseDAOImpl();
      
		List<Course> courses = dao.FindAllCourses();
	%>
	
	<table border="1">
	<tr bgcolor="00FF7F">
<th><b>Course_id</b></th>
<th><b>Name</b></th>
<th><b>Type</b></th>
<th><b>Credits</b></th>
<th><b>Semester</b></th>
</tr>
<%for(int i=0;i<courses.size();i++)
	{%>
<tr>
<td><%=courses.get(i).getCourse_id() %></td>
<td><%=courses.get(i).getName()%></td>
<td><%=courses.get(i).getType()%></td>
<td><%=courses.get(i).getCredits() %></td>
<td><%=courses.get(i).getSem() %></td>
<%} %>
	</table>

</body>
</html>
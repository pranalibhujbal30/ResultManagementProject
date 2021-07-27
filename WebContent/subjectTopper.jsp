<%@page import="com.pojo.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CourseDAOImpl"%>
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
<%
//List<Course> courses=new
CourseDAOImpl dao=new CourseDAOImpl();
List<Course> courses = dao.FindAllCourses();
%>
<form action="SubjectTopper" method="post">
<label for="course_id">choose a Course</label>
<select name="course_id" id="course_id">
<% for(int i=0;i<courses.size();i++)
{
%>
<option value="<%=courses.get(i).getCourse_id()%>"><%=courses.get(i).getName()%></option>
<%}%>
<input type="submit" value="Show">
</select>
</form>

</body>
</html>
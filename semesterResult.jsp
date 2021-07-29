<%@page import="com.dao.ResultDAO"%>
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

<%String CNo=(String)session.getAttribute("username");
List<Course2> courses = new ArrayList<>();
float sgpa=0.0f;

String semester=(String)request.getParameter("semester");

ResultDAO dao=new ResultDAO();
courses=dao.displayResultOfSemester(CNo, semester);
sgpa=dao.getSGPAOfSemester(CNo, semester);

request.setAttribute("courses", courses);
request.setAttribute("sgpa", sgpa);
request.getRequestDispatcher("resultDisplay.jsp").forward(request, response);
%>

</body>
</html>
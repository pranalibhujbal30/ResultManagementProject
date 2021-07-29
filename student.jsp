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
String CNo=(String)session.getAttribute("username");
if(session.getAttribute("username")!=null)
{
	out.println("Welcome");
	out.println(session.getAttribute("username"));
	
}%>



<br>
<a href="ResultAnalysis.jsp">display SGPA</a>
<br>
<a href="myResult.jsp">display Result</a>
<br>
<a href="semsterResultForm.jsp">Display result of previous semesters</a>
</body>
</html>
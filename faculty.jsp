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
String action=(String)request.getAttribute("validate");
if(action!=null && action.equals("yes"))
{
%>
<script type="text/javascript">alert(Successful login);</script>
<%} %>

<a href="addResult.jsp">Add Result</a>
<br>
<a href="displayResult.jsp">display Result</a>
<br>
<a href="topper.jsp">Toppers</a>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="addResult.jsp">Add Result</a>

<%
String action=(String)request.getAttribute("validate");
if(action!=null && action.equals("yes"))
{
%>
<script type="text/javascript">
alert(Successful log in);
</script>
<%
}
%>

</body>
</html>
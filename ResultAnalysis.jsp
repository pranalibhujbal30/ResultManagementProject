<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
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
<%String CNo=(String)session.getAttribute("username");
//out.println(CNo);
ResultDAO dao=new ResultDAO();
ResultSet set=dao.sgpaGraph(CNo);
try {
	set.next();
	request.setAttribute("sem1", set.getFloat(2));
	request.setAttribute("sem2", set.getFloat(3));
	request.setAttribute("sem3", set.getFloat(4));
	request.setAttribute("sem4", set.getFloat(5));
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

request.getRequestDispatcher("/sgpaGraph.jsp").forward(request, response);
%>

</body>
</html>
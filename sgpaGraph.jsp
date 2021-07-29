
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;
List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
 
map = new HashMap<Object,Object>(); map.put("label", "sem1"); map.put("y", request.getAttribute("sem1")); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "sem2"); map.put("y", request.getAttribute("sem2")); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "sem3"); map.put("y", request.getAttribute("sem3")); list.add(map);
map = new HashMap<Object,Object>(); map.put("label", "sem4"); map.put("y", request.getAttribute("sem4")); list.add(map);
String dataPoints = gsonObj.toJson(list);
%>
 
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
window.onload = function() { 
 
var chart = new CanvasJS.Chart("chartContainer", {
	title: {
		text: "Result Analysis"
	},
	axisX: {
		title: "Semester"
	},
	axisY: {
		title: "SGPA",
		includeZero: true
	},
	data: [{
		type: "column",
		yValueFormatString: "#,##0.0#",
		dataPoints: <%out.print(dataPoints);%>
	}]
});
chart.render();
 
}
</script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
  </body>
</html>


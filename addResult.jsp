<%@page import="com.dao.ResultImplDAO"%>
<%@page import="com.pojo.Result"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Result</title>

<!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;900&family=Ubuntu:wght@300;400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Grenze:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">

    <!-- Admin Style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="Style/AddResult.css">

    <!-- Favicon link -->
    <link rel="icon" href="Images/karve-icon.png">

    <!-- Font Awesome -->
    <script src="https://kit.fontawesome.com/dbb0e0b23a.js" crossorigin="anonymous"></script>

    <!-- Bootstrap Scripts -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<body>

<!-- Navigation Bar -->
<div class="navbar">
  <div class="dropdown">
      <button class="dropbtn">SGPA</button>
      <div class="dropdown-content">
         <a href="addSGPA.jsp"> Calculate SGPA </a>
         <a href="displaySgpa.jsp"> View SGPA </a>
      </div>
    </div>
    <div class="return-back">
      <a href="A_display.html">
         <button class="back">Return back</button>
      </a>
     </div>
</div>
    
<div class="addresult" align="center">
<h1>Add Result</h1>
<br>
<form  method="post">
<table>
<tr><td>Examination: </td><td><input type="text" name="exam_type"></td></tr>
<tr><td>Course Id: </td><td><input type="text" name="course_id"></td></tr>
<tr><td>Excel Sheet Path: </td><td><input type="text" name="file_path"></td></tr>
<tr><td></td><td><button class="btn">INSERT</button></td></tr>
</table>
</form>

</div>

</body>
</html>
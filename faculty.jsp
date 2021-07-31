<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Faculty Page</title>

<!-- Google Fonts -->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;900&family=Ubuntu:wght@300;400;700&display=swap" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Grenze:wght@600&display=swap" rel="stylesheet">

  <!-- CSS link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="Style/A_display.css">

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

<!-- Home Page Section -->

  <section class="home-page">

    <!-- Navigation Bar -->

    <nav class="navbar navbar-expand-sm">
      <nav class="navbar-brand">
        <div class="navbar-header">
          <a href="index.html">
            <img src="Images/cummins-college-logo.png" alt="">
          </a>
        </div>
      </nav>

      <!-- Right-side of tha Nav bar -->
      <ul class="navbar-nav ml-auto">
        <li class="nav-item">
          <a class="nav-link" href="Admin.html">Logout</a>
        </li>
      </ul>
    </nav>
 
  </section>
  
  <!-- White Section -->

  <section class="white-section">
     <h2 class="heading-section">LOGIN SUCCESSFULL!!</h2>    
  </section>
  
  <!-- Main Section -->
  <section class="card-deck-section">
      <div class="main-section">

<!-- Gray Section -->
<div class="dashbord">
<div class="icon-section">
<i class="fas fa-users" aria-hidden="true"></i><br>
<h2>Faculty</h2><br><br>
</div>
<div class="detail-section">
<div class="dropdown">
<a href="#">More Info </a>
      <div class="dropdown-content">
         <a href="addResult.jsp"> Add Result </a>
         <a href="displayResult.jsp"> View Result </a>
         <a href="topper.jsp"> View Topper</a>
      </div>
    </div>
</div>
</div>

</div>
        
</section>


</body>
</html>
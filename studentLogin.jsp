<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link href="Style/Stud_styles.css" rel="stylesheet" type="text/css">
  
</head>
<body>


<div>
    <section class="home-page">

      

      <u></u>
        <u></u>
          <div class="navbar-header">
            <a href="#m__" rel="noreferrer">
              <img src="https://ci5.googleusercontent.com/proxy/I-Axn7Rn9UYcQNN-J_cpTuYKKbQUruQmGcnT8Lx-tEuYlIT7vY_UpQKThoBqnRX5272awmc_VH4T=s0-d-e1-ft#http://Images/cummins-college-logo.png" alt="">
            </a>
          </div>
        <u></u>

        
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="https://www.google.com/url?q=http://index.html&amp;source=gmail-html&amp;ust=1627652789895000&amp;usg=AFQjCNG8LKDzjJnhs193eMWq2nFf7wKxdQ" rel="noreferrer">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="https://www.google.com/url?q=http://Admin.html&amp;source=gmail-html&amp;ust=1627652789895000&amp;usg=AFQjCNHrgYCC2-In4LS9ebSlRHB12DtbXQ"  rel="noreferrer">Admin</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="https://www.google.com/url?q=http://Student.html&amp;source=gmail-html&amp;ust=1627652789895000&amp;usg=AFQjCNHa7L1PSkFQR_b3Yc9AA-dgqwLvdQ"  rel="noreferrer">Student</a>
          </li>
        </ul>
      <u></u>

    </section>

    
    <section class="white-section"></section>

    <section class="container-fluid">
      <i class="student-icon fas fa-user-graduate fa-3x"></i>
      <h2 class="heading-section">Student Login</h2>
      <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">
          <form class="form-container" action="StudentLogin" method="post">
            <div class="form-group">
              <label for="Email">C Number</label>
              <input type="text" class="form-control" id="m_Email" name="username">
            </div>
            <div class="form-group">
              <label for="Password">Password</label>
              <input type="password" class="form-control" id="m_Password" name="password">
            </div>
            <div class="checkbox">
              <label>
                <a class="fp" href="https://www.google.com/url?q=http://ForgotP.html&amp;source=gmail-html&amp;ust=1627652789895000&amp;usg=AFQjCNE0sNQQu1GvUKyVgFZQpFFVKTVzkw" target="_blank" rel="noreferrer">Forgot Password?</a>
              </label>
            </div>
            <% if(session.getAttribute("msg")!=null)
{%>
	<font color="Red"><% out.println(session.getAttribute("msg"));%></font>
	<%session.removeAttribute("msg");
}
	%>
           <input type="submit" value="login"></td></tr>
          </form>
        </div>


      </div>

    </section>

  </div>

</body>
</html>
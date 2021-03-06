
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="utf-8">
    <title>Admin Page</title>

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;300;900&family=Ubuntu:wght@300;400;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Grenze:wght@600&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP&display=swap" rel="stylesheet">

    <!-- Admin Style -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="Style/Admin_styles.css">

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
    <section class="home-page">

      <!-- Navigation Bar -->

      <nav class="navbar navbar-expand-sm">
        <nav class="navbar-brand">
          <div class="navbar-header">
            <a href="#">
              <img src="Images/cummins-college-logo.png" alt="">
            </a>
          </div>
        </nav>

        <!-- Right-side of tha Nav bar -->
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="index.html">Home</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="Admin.html">Admin</a>
          </li>
          
          <li class="nav-item">
            <a class="nav-link" href="facultyLogin.jsp">Faculty</a>
          </li>

          <li class="nav-item">
            <a class="nav-link" href="Student.html">Student</a>
          </li>
        </ul>
      </nav>

    </section>

    <!-- White Section -->
    <section class="white-section"></section>

    <section class="container-fluid">
      <i class="admin-icon far fa-user fa-3x"></i>
      <h2 class="heading-section">Faculty Login</h2>
      <div class="row">
        <div class="col-md-4 col-sm-4 col-xs-12"></div>
        <div class="col-md-4 col-sm-4 col-xs-12">
          <form class="form-container" action="faculty.jsp">
            <div class="form-group">
              <label for="Email">Email address</label>
              <input type="email" class="form-control" id="Email" placeholder="Email" required>
            </div>
            <div class="form-group">
              <label for="Password">Password</label>
              <input type="password" class="form-control" id="Password" placeholder="Password" required>
            </div>
            <div class="checkbox">
              <label>
                <input type="checkbox"> Remember me
              </label>
            </div>
            <button type="submit" class="btn btn-block">Log in</button>
          </form>
        </div>


      </div>

    </section>

  </body>
</html>

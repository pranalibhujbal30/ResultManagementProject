package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.loginDAO;
import com.pojo.LoginBean;


@WebServlet("/FacultyLogin")
public class FacultyLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FacultyLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginBean loginbean= new LoginBean();
		loginbean.setUsername(username);
		loginbean.setPassword(password);
		
		if(loginDAO.validate(loginbean))
		{
			request.setAttribute("validate", "yes");
			 request.getRequestDispatcher("/faculty.jsp").forward(request, response);
			 
		}
		else
		{
			request.setAttribute("validate", "no");
			 request.getRequestDispatcher("/facultyLogin.jsp").forward(request, response);
		}
	}

}

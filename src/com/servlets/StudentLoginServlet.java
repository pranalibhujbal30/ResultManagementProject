package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.loginDAO;
import com.pojo.LoginBean;

@WebServlet("/StudentLogin")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public StudentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String msg=null;
		HttpSession session = request.getSession(true);
		if(loginDAO.validateStudent(username,password))
		{
			//msg=Successful Login;
			out.println("Successful login");
			session.setAttribute("username", username);
			response.sendRedirect("student.jsp");
		}
		else
		{
			msg="invalid credentials";
			session.setAttribute("msg", msg);
			//out.println("invalid credentials");
			response.sendRedirect("studentLogin.jsp");
			
			
		}
	}

	}



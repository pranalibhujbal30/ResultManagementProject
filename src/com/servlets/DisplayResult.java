package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ResultDAO;
import com.pojo.Course2;


@WebServlet("/DisplayResult")
public class DisplayResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public DisplayResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String CNo=request.getParameter("CNo");
		List<Course2> courses = new ArrayList<>();
		float sgpa=0.0f;
		
		ResultDAO dao=new ResultDAO();
		courses=dao.displayResult(CNo);
		sgpa=dao.getSGPA(CNo);
		
		request.setAttribute("courses", courses);
		request.setAttribute("sgpa", sgpa);
		request.getRequestDispatcher("resultDisplay.jsp").forward(request, response);
	}

}

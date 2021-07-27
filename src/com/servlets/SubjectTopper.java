package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ResultDAO;
import com.mysql.cj.protocol.Resultset;

@WebServlet("/SubjectTopper")
public class SubjectTopper extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SubjectTopper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String course_id= request.getParameter("course_id");
		ResultDAO dao=new ResultDAO();
		ResultSet set=dao.subjectTopper(course_id);
		
		try {
			set.next();
			request.setAttribute("CNo", set.getString(1));
			request.setAttribute("Total_marks", set.getInt(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("displaySubjectTopper.jsp").forward(request, response);
		
	}

}

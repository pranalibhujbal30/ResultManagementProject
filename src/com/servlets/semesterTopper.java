package com.servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hpsf.Array;

import com.dao.ResultDAO;

@WebServlet("/semesterTopper")
public class semesterTopper extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public semesterTopper() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String semester=request.getParameter("semester");
		ResultDAO dao=new ResultDAO();
		ResultSet set=dao.semesterTopper(semester);
		try {
			set.next();
			request.setAttribute("CNo", set.getString(1));
			request.setAttribute("name", set.getString(2));
			request.setAttribute("division",set.getString(3));
			request.setAttribute("semester", set.getInt(4));
			request.setAttribute("sgpa", set.getFloat(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		request.getRequestDispatcher("/displaySemesterTopper.jsp").forward(request, response);
		
	}

}

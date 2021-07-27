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

@WebServlet("/sgpaGraph")
public class sgpaGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public sgpaGraph() {
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
		ResultDAO dao=new ResultDAO();
		ResultSet set=dao.sgpaGraph(CNo);
		try {
			set.next();
			request.setAttribute("sem1", set.getFloat(2));
			request.setAttribute("sem2", set.getFloat(3));
			request.setAttribute("sem3", set.getFloat(4));
			request.setAttribute("sem4", set.getFloat(5));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/sgpaGraph.jsp").forward(request, response);
		
		
	}

}

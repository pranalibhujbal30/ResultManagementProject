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
import com.dao.ResultImplDAO;
import com.pojo.Sgpa;

@WebServlet("/getSgpaOfAll")
public class getSgpaOfAll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public getSgpaOfAll() {
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
		List<Sgpa> sgpa = new ArrayList<>();
		ResultDAO dao=new ResultDAO();
		sgpa=dao.getSgpaOfAll(semester);
		request.setAttribute("sgpa", sgpa);
		request.getRequestDispatcher("displaySgpaOfAll.jsp").forward(request, response);
	}

}

package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.CourseDAO;
import com.dao.CourseDAOImpl;
import com.dao.loginDAO;
import com.pojo.Course;
import com.pojo.LoginBean;

/**
 * Servlet implementation class AddCourse
 */
@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String course_id=request.getParameter("course_id");
		String name=request.getParameter("name");
		String type=request.getParameter("type");
		String sem=request.getParameter("sem");
		String credits=request.getParameter("credits");
		
		CourseDAO dao = new CourseDAOImpl();
		Course course=new Course();
		course.setCourse_id(course_id);
		course.setName(name);
		course.setType(type);
		course.setSem(sem);
		course.setCredits(credits);
		
		
		if(dao.addCourse(course)>0)
		{
			response.sendRedirect("admin.jsp");
		}
		else
		{
			response.sendRedirect("addCourse.jsp");
		}
	
	}

}

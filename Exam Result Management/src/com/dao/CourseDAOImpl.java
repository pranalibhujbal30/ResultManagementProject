package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.pojo.Course;



public class CourseDAOImpl implements CourseDAO {
	
	@Override
	public int addCourse(Course course) {
		// TODO Auto-generated method stub
		int added = 0;

		Connection con = new MyConnection().getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into course(course_id,name,type,sem,credits) values(?,?,?,?,?)");
			ps.setString(1, course.getCourse_id());
			ps.setString(2, course.getName());
			ps.setString(3, course.getType());
			ps.setString(4, course.getSem());
			ps.setString(5, course.getCredits());
			added = ps.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return added;
	}


	@Override
	public List<Course> FindAllCourses() {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();

		Connection con = new MyConnection().getConnection();

		Statement st;
		try {
			st = con.createStatement();
			ResultSet set = st.executeQuery("select * from course");
			while (set.next()) {
				Course course = new Course(set.getString(1),set.getString(2), set.getString(3), set.getString(4), set.getString(5));
				courses.add(course);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courses;
	}

}

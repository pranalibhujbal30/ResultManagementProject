package com.dao;
import java.util.List;

import com.pojo.Course;


public interface CourseDAO {
	
	public int addCourse(Course course);
	public List<Course> FindAllCourses();

}

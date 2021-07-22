/**
 * 
 */
package com.dao;

import java.util.List;

import com.pojo.Student;

/**
 * @author janhavi
 *
 */
public interface TopperDAO {
	public List<String> getTopperCourseWise(String courseId);
	
}

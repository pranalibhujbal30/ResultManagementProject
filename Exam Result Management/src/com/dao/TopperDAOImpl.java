/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.pojo.Course;
import com.pojo.Student;

/**
 * @author janhavi
 *
 */
public class TopperDAOImpl implements TopperDAO {
	@Override
	public List<String> getTopperCourseWise(String courseId){
//		Student topper = new Student();
		Connection con = new MyConnection().getConnection();
		List<String> toppers = new ArrayList<>();
		Statement st;
		try { 
			st = con.createStatement();
//			String query = "select semester from course where course_id="+courseId;
//			ResultSet set = st.executeQuery(query);
//			int sem = set.getInt(1); 
			String query = "select CNo from sem_4 where "+courseId+"=(select MAX("+courseId+") from sem_4)";
			ResultSet set = st.executeQuery(query);
			
			
//			while (set.next()) { 
//				toppers.add(set.getCharacterStream(
//			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return toppers;
	}
}

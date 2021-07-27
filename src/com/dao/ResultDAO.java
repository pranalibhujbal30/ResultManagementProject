package com.dao;


import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connections.MyConnection;
import com.mysql.cj.protocol.Resultset;
import com.pojo.Course;
import com.pojo.Course1;
import com.pojo.Course2;

public class ResultDAO {
	
	public int addSGPA(String semester)
	{
		Connection con = new MyConnection().getConnection();
		List<Course1> courses = new ArrayList<>();
		int added=0;
		try {
			String sql1="select CNo from sem_"+semester+"";
			Statement st1 = con.createStatement();
			ResultSet set1= st1.executeQuery(sql1);
			
			String sql2="select course_id,credits from Course where semester=?";
			PreparedStatement ps1;
			ps1 = con.prepareStatement(sql2);
			ps1.setString(1, semester);
			 ResultSet set2=ps1.executeQuery();
			 while (set2.next()) {
					Course1 course = new Course1(set2.getString(1),set2.getInt(2));
					courses.add(course);
				}
		    
		    while(set1.next())
		    {
		    	float sgpa=0.0f;
		    	String CNo=set1.getString(1);
		    	System.out.println(CNo);
		    	
		    	sgpa=calculateSGPA(courses,CNo,semester);
		    	
		    	System.out.println(sgpa);
		    	String sql3="update sgpa set sem_"+semester+" = ? where CNo=?";
		    	 PreparedStatement ps2=con.prepareStatement(sql3);
					ps2.setFloat(1, sgpa);
					ps2.setString(2, CNo);
					added=ps2.executeUpdate();
					System.out.println(added);
		    	
		    }
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}
	
	public float calculateSGPA(List<Course1> courses,String CNo,String semester)
	{
		Connection con = new MyConnection().getConnection();
		float point=0.0f;
		float total_points=0.0f;
		float credits=0.0f;
		float credits_gained=0.0f;
		float sgpa=0.0f;
		try {
			for(int i=0;i<courses.size();i++)
			{
				System.out.println(courses.get(i).getCourse_id());
				String sql1="select "+courses.get(i).getCourse_id()+"_grade from sem_"+semester+" where CNo=?";
				PreparedStatement ps1=con.prepareStatement(sql1);
				ps1.setString(1,CNo);
				ResultSet set1=ps1.executeQuery();
				set1.next();
				String grade=set1.getString(1);
				System.out.println(grade);
				int grade_point=calculateGradePoint(grade);
				if(grade.equals("F"))
				{
					point=0.0f;
					credits=0.0f;
				}
				
				else
				{
					point=grade_point*courses.get(i).getCredits();
					credits=courses.get(i).getCredits();
				}
					
				total_points=total_points+point;
				credits_gained=credits_gained+courses.get(i).getCredits();
				//System.out.println(set.getString(1));
			}
			
			sgpa=total_points/credits_gained;
			
			
			
		    
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sgpa;
		
	}
	
	public int calculateGradePoint(String grade)
	{
		int grade_point=0;
		if(grade.equals("A+"))
			grade_point=10;
		else if(grade.equals("A"))
			grade_point=9;
		else if(grade.equals("B+"))
			grade_point=8;
		else if(grade.equals("B"))
			grade_point=7;
		else if(grade.equals("C+"))
			grade_point=6;
		else if(grade.equals("C"))
			grade_point=5;
		else if(grade.equals("F"))
			grade_point=0;
		return grade_point;
		
	}
	
	public List<Course2> displayResult(String CNo)
	{
		Connection con = new MyConnection().getConnection();
		List<Course2> courses = new ArrayList<>();
		String sql1="select semester from student where CNo=?";
		PreparedStatement ps1;
		try {
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, CNo);
			ResultSet set1=ps1.executeQuery();
			
			set1.next();
			System.out.println(set1.getInt(1));
			
			String sql2="select course_id from Course where semester= ?";
			ps1=con.prepareStatement(sql2);
			ps1.setString(1, set1.getString(1));
			ResultSet set2=ps1.executeQuery();
		
			int i=0;
			while(set2.next())
			{
				String sql3="select "+set2.getString(1)+","+set2.getString(1)+"_grade from sem_"+set1.getString(1)+" where CNo=?";
			    PreparedStatement ps2=con.prepareStatement(sql3);
			    ps2.setString(1, CNo);
			    ResultSet set3=ps2.executeQuery();
			    set3.next();
			    Course2 course=new Course2(set2.getString(1),set3.getInt(1),set3.getString(2));
			    courses.add(course);
				System.out.println(set2.getString(1));
				System.out.println(set3.getInt(1));
				System.out.println(set3.getString(2));
				
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return courses;
		
	}
	
	public void getSemesterResult(String semester)
	{
		Connection con = new MyConnection().getConnection();
		
		String sql1="select course_id from Course where semester= ?";
		
		try {
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ps1.setString(1,semester);
			ResultSet set1=ps1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql2="select * from sem_"+semester+"";
		
	}
	
	
	
	public Float getSGPA(String CNo)
	{
		Connection con = new MyConnection().getConnection();
		String sql1="select semester from student where CNo=?";
		PreparedStatement ps1;
		Float sgpa =0.0f;
		try {
			ps1 = con.prepareStatement(sql1);
			ps1.setString(1, CNo);
			ResultSet set1=ps1.executeQuery();
			
			set1.next();
			System.out.println(set1.getInt(1));
			
			PreparedStatement ps2;
			String sql2="select sem_"+set1.getInt(1)+" from sgpa where CNo=?";
			ps2=con.prepareStatement(sql2);
			ps2.setString(1, CNo);
			ResultSet set2 =ps2.executeQuery();
			set2.next();
			sgpa=set2.getFloat(1);

			System.out.println(sgpa);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sgpa;
		
	}
	
	
	public ResultSet semesterTopper(String semester)
	{
		String sql="select student.CNo, student.name,student.division, student.semester, sgpa.sem_"+semester+" from student inner join sgpa on student.CNo=sgpa.CNo where student.semester=? order by sgpa.sem_"+semester+" desc limit 1";
		Connection con = new MyConnection().getConnection();
		PreparedStatement ps1;
		ResultSet set=null;
		try {
			ps1=con.prepareStatement(sql);
			ps1.setString(1, semester);
			set=ps1.executeQuery();
			/*while(set.next())
			{
				System.out.println(set.getString(1));
				System.out.println(set.getInt(2));
				System.out.println(set.getFloat(3));
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	public ResultSet subjectTopper(String course_id)
	{
		Connection con = new MyConnection().getConnection();
		String sql1="select semester from Course where course_id=?";
		
		
		Statement st;
		ResultSet set = null;
		try {
			PreparedStatement ps1=con.prepareStatement(sql1);
			ps1.setString(1, course_id);
			ResultSet set1=ps1.executeQuery();
			set1.next();
			int semester=set1.getInt(1);
			st=con.createStatement();
			
		    String sql2="select CNo,"+course_id+" from sem_"+semester+" where "+course_id+" =(select max("+course_id+") from sem_"+semester+")";
		    set=st.executeQuery(sql2);
			/*while(set.next())
			{
				System.out.println(set.getString(1));
				System.out.println(set.getInt(2));
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	public ResultSet sgpaGraph(String CNo)
	{
		Connection con = new MyConnection().getConnection();
		String sql="select * from sgpa where CNo=?";
		ResultSet set=null;
		try {
			PreparedStatement ps1=con.prepareStatement(sql);
			ps1.setString(1, CNo);
			 set =ps1.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	

	


}


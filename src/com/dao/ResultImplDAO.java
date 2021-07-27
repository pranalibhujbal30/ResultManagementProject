package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.connections.MyConnection;
import com.pojo.Course;

public class ResultImplDAO {
	public int addResult(String exam_type, String course_id,String file_path)
	{
	       
	        String excelFilePath = file_path;
	 
	        int added = 0;
	 
	        Connection con = new MyConnection().getConnection();
	 
	        try {	             
	            FileInputStream inputStream = new FileInputStream(excelFilePath);
	 
	            Workbook workbook = new XSSFWorkbook(inputStream);
	            DataFormatter dataformatter = new DataFormatter();
	       
	            Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	             
	            int count = 0;
	  
	             Row row;
	             for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
	                 row = (Row) firstSheet.getRow(i);
	                 String CNo = row.getCell(0).getStringCellValue();
	                 //String course_id = course_id;

	                 int  in_sem = (int) row.getCell(2).getNumericCellValue();

	                 int end_sem =(int) row.getCell(3).getNumericCellValue();
	                 int credits =(int) row.getCell(4).getNumericCellValue();

	                 String sql = "INSERT INTO result (CNo, course_id, in_sem, end_sem,credits) VALUES('" + CNo + "','" + course_id + "'," + in_sem + "," + end_sem + ","+credits+")";
	                 PreparedStatement ps =  con.prepareStatement(sql);
	                added= ps.executeUpdate();
	                 System.out.println("Import rows " + i);
	             }
	 
	            workbook.close();
	            
	            con.close();
	          
	        } catch (IOException ex1) {
	            System.out.println("Error reading file");
	            ex1.printStackTrace();
	        } catch (SQLException ex2) {
	            System.out.println("Database error");
	            ex2.printStackTrace();
	        }
	        
	        return added;
	}
	
	
	public int updateResult(String semester,String exam_type,String course_id, String file_path)
	{
		int added=0;
		 Connection con = new MyConnection().getConnection();
		 String excelFilePath = file_path;
		 
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			 Workbook workbook = new XSSFWorkbook(inputStream);
	          DataFormatter dataformatter = new DataFormatter();
	          Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	            
	            Row row;
	            row=firstSheet.getRow(0);
	     
	            	for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
	                 row = (Row) firstSheet.getRow(i);
	                
	                 String CNo = row.getCell(0).getStringCellValue();

	                 int  marks = (int) row.getCell(1).getNumericCellValue();

	                 String sql = "update sem_"+semester+" set "+course_id+"_"+exam_type+" = ? where  CNo= ?";
	                 PreparedStatement ps =  con.prepareStatement(sql);
	                 ps.setInt(1, marks);
	                 ps.setString(2, CNo);
	                 added=added+ ps.executeUpdate();
	                 System.out.println("Import rows " + i);
	                 System.out.println(marks+" ,"+CNo);
	                 System.out.println(added);
	             }
	            	 workbook.close();
	 	            
	 	            con.close();
	          
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 
      
		return added;
		
	}
	
	public int calculateResult(String semester) {
		 Connection con = new MyConnection().getConnection();
		 String sql= "select * from Course where semester=?";
		 List<Course> courses = new ArrayList<>();
		 int added=0;
		 
		 try
		 {
			 PreparedStatement st=con.prepareStatement(sql);
			 st.setString(1, semester);
				ResultSet set=st.executeQuery();
				while (set.next()) {
					Course course = new Course(set.getString(1),set.getString(2), set.getString(3), set.getString(4), set.getString(5));
					courses.add(course);
				}
				String sql2="select CNo from sem_"+semester+"";
				Statement st2 = con.createStatement();
				
				
				for(int i=0;i<courses.size();i++)
				 {
					 String course_id=courses.get(i).getCourse_id();
					 String sql1="select "+course_id+"_t1,"+course_id+"_t2,"+course_id+"_ese from sem_"+semester;
					 Statement st1;
					 
						st1 = con.createStatement();
						ResultSet set1=st1.executeQuery(sql1);
						ResultSet set2= st2.executeQuery(sql2);
						
						 while (set1.next() && set2.next())
						 {
							 String grade="";
							 System.out.println(set1.getInt(1)+", "+set1.getInt(2)+" ,"+set1.getInt(3));
							 System.out.println(set2.getString(1));
							 int total=0;
							 total=set1.getInt(1)+set1.getInt(2)+set1.getInt(3);
							 System.out.println(total);
							 if(set1.getInt(3)<20)
								 grade="F";
							 else
							 {
								  grade=calculateGrade(total);
							 }
								 
								 System.out.println(grade);
								// update sem_3 set CE2101=90 , CE2101_grade="A" where CNo="C22018881901";
								String sql3= "update sem_"+semester+" set "+course_id+" = ? , "+course_id+"_grade=? where CNo=?";
								 PreparedStatement st3=con.prepareStatement(sql3);
								st3.setInt(1, total);
								st3.setString(2, grade);
								st3.setString(3, set2.getString(1));
								
								added=st3.executeUpdate();
								
								

					 }
						 System.out.println("completed course "+i);
						 
				 }
			 
		 }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
		 return added;
		 }
	
	
	public String calculateGrade(int total)
	{
		 String grade="";
		 if(total>90)
			 grade="A+";
		 else if(total>80)
			 grade="A";
		 else if(total>70)
			 grade="B+";
		 else if(total>60)
			 grade="B";
		 else if(total>50)
			 grade="C+";
		 else if(total>=40)
			 grade="C";
		 else
			 grade="F";
		 return grade;
			 
	}
	
	
		 
	}
	


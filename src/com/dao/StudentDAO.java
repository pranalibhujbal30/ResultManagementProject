package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.connections.MyConnection;

public class StudentDAO {
	
	public int insertStudent(String file_path)
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
	                 
	                String CNo= row.getCell(0).getStringCellValue();
	                System.out.println(CNo);
	                String password=row.getCell(1).getStringCellValue();
	                System.out.println(password);
	                String name=row.getCell(2).getStringCellValue();
	                System.out.println(name);
	                String division=row.getCell(3).getStringCellValue();
	                System.out.println(division);
	                int Semester=(int) row.getCell(4).getNumericCellValue();
	                System.out.println(Semester);
	                int year=(int) row.getCell(5).getNumericCellValue();
	                System.out.println(year);
	             
	                
	                String email_id=row.getCell(7).getStringCellValue();
	                System.out.println(email_id);
	                
	                 //String sql="insert into student values(?,?,?,?,?,?,?,?)";
	                String sql1="insert into sgpa(CNo) values('"+CNo+"')";
	                 String sql = "INSERT INTO student(CNo, password,name,division,Semester,year,email_id) VALUES('"+CNo+"','"+password+"','" +name+ "','" +division+ "',"+Semester+","+year+",'"+email_id+"')";
	                 PreparedStatement ps =  con.prepareStatement(sql);
	                 PreparedStatement ps1=con.prepareStatement(sql1);
	                 added= ps.executeUpdate();
	                 added=added+ps1.executeUpdate();
	                 System.out.println("Import rows " + i);
	                
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
	
	public int updateStudent(String file_path)
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
	                 System.out.println(CNo);
	                 String name=row.getCell(1).getStringCellValue();
	                 System.out.println(name);
	                 String division = row.getCell(2).getStringCellValue();
	                 System.out.println(division);
	                 int semester =(int) row.getCell(3).getNumericCellValue();
	                 System.out.println(semester);
	                 int year=(int) row.getCell(4).getNumericCellValue();
	                 System.out.println(year);
	                 

	                 String sql = "update student set name=? , division=? , Semester=? , year= ? where  CNo=?";
	                 PreparedStatement ps =  con.prepareStatement(sql);
	                 ps.setString(1, name);
	                 ps.setString(2, division);
	                 ps.setInt(3, semester);
	                 ps.setInt(4, year);
	                ps.setString(5, CNo);
	                  ps.executeUpdate();
	                 System.out.println("updated in student");
	                 added=insertIntoSemester(semester, CNo);
	             
	                 System.out.println("Import rows " + i);
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
	
	public int insertIntoSemester(int semester,String CNo)
	{
		 Connection con = new MyConnection().getConnection();
		int added=0;
		String sql="insert into sem_"+semester+" (CNo) values('"+CNo+"')";
		try {
			PreparedStatement ps1=con.prepareStatement(sql);

			added=ps1.executeUpdate();
			System.out.println("inserted in sem");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added; 
	}
	

}

package com.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.connections.MyConnection;

public class ResultDAO {
	
	public void addResult()
	{
		try {
			 PreparedStatement pstm = null;
			 Connection con = new MyConnection().getConnection();
			 String filePath = "G:\\Result.xlsx";
	         FileInputStream input = new FileInputStream(filePath);
	         POIFSFileSystem fs = new POIFSFileSystem(input);
	         HSSFWorkbook wb = new HSSFWorkbook(fs);

	         HSSFSheet sheet = wb.getSheetAt(0);
	         Row row;
	         for (int i = 1; i <= sheet.getLastRowNum(); i++)
	         {
	        	 row = sheet.getRow(i);
	             String CNo = row.getCell(0).getStringCellValue();
	             String course_id = row.getCell(1).getStringCellValue();
	             int in_sem = (int) row.getCell(2).getNumericCellValue();
	             int end_sem = (int) row.getCell(3).getNumericCellValue();
	            int credits = (int) row.getCell(4).getNumericCellValue();


	             String sql = "INSERT INTO result VALUES('" + CNo + "','" + course_id + "','" + in_sem + "','" + end_sem + "','" + credits +"')";
	             pstm = (PreparedStatement) con.prepareStatement(sql);
	             pstm.execute();
	             System.out.println("Import rows " + i);
	         }
	         con.commit();
	         pstm.close();
	         con.close();
	         input.close();
	         System.out.println("Success import excel to mysql table");
		}catch (IOException e) {
         e.printStackTrace();
     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

}
}


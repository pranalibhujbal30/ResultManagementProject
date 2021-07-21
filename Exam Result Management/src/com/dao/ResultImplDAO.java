package com.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.connections.MyConnection;

public class ResultImplDAO {
	public int addResult(String exam_type, String course_id,String file_path)
	{
	       
	        String excelFilePath = file_path;
	 
	        int added = 0;
	 
	        Connection con = new MyConnection().getConnection();
	 
	        try {
	            //long start = System.currentTimeMillis();
	             
	            FileInputStream inputStream = new FileInputStream(excelFilePath);
	 
	            Workbook workbook = new XSSFWorkbook(inputStream);
	            DataFormatter dataformatter = new DataFormatter();
	            //Iterator<Sheet> sheets = workbook.sheetIterator();
	       
	 
	            Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	
	           // String sql = "INSERT INTO result (CNo, course_id, in_sem, end_sem, credits) VALUES (?, ?, ?, ?, ?)";
	            //PreparedStatement statement = con.prepareStatement(sql);    
	             
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
	           /* rowIterator.next(); // skip the header row
	             
	            while (rowIterator.hasNext()) {
	                Row nextRow = rowIterator.next();
	                Iterator<Cell> cellIterator = nextRow.cellIterator();
	 
	                while (cellIterator.hasNext()) {
	                    Cell nextCell = cellIterator.next();
	 
	                    int columnIndex = nextCell.getColumnIndex();
	 
	                    switch (columnIndex) {
	                    case 0:
	                    	String CNo= dataformatter.formatCellValue(nextCell);
	                       // String CNo = nextCell.getStringCellValue().toString();
	                        statement.setString(1, CNo);
	                        break;
	                    case 1:
	                        String course_id = nextCell.getStringCellValue().toString();
	                        statement.setString(2, course_id);
	                    case 2:
	                        //String in_sem = nextCell.getStringCellValue();
	                        statement.setString(3, in_sem);
	                    case 3:
	                    	String end_sem =nextCell.getStringCellValue();
	                        statement.setString(4, end_sem);
	                    case 4:
	                    	String credits =  nextCell.getStringCellValue();
	                        statement.setString(5, credits);
	                    	
	                    }
	 
	                }
	                statement.addBatch();
	                 
	                if (count % batchSize == 0) {
	                    statement.executeBatch();
	                }              
	 
	            }*/
	 
	            workbook.close();
	             
	            // execute the remaining queries
	           // statement.executeBatch();
	  
	            //con.commit();
	            con.close();
	             
	           // long end = System.currentTimeMillis();
	           // System.out.printf("Import done in %d ms\n", (end - start));
	             
	        } catch (IOException ex1) {
	            System.out.println("Error reading file");
	            ex1.printStackTrace();
	        } catch (SQLException ex2) {
	            System.out.println("Database error");
	            ex2.printStackTrace();
	        }
	        
	        return added;
	}
	
	
	public int updateResult(String exam_type,String course_id, String file_path)
	{
		int added=0;
		 Connection con = new MyConnection().getConnection();
		 String excelFilePath = file_path;
		 String course=course_id;
		 
		try {
			FileInputStream inputStream = new FileInputStream(excelFilePath);
			 Workbook workbook = new XSSFWorkbook(inputStream);
	          DataFormatter dataformatter = new DataFormatter();
	          Sheet firstSheet = workbook.getSheetAt(0);
	            Iterator<Row> rowIterator = firstSheet.iterator();
	            
	            Row row;
	            row=firstSheet.getRow(0);
	            course=row.getCell(1).getStringCellValue();
	            	for (int i = 1; i <= firstSheet.getLastRowNum(); i++) {
	                 row = (Row) firstSheet.getRow(i);
	                
	                 String CNo = row.getCell(0).getStringCellValue();
	                 //String course_1= row.getCell(1).getStringCellValue();

	                 int  marks = (int) row.getCell(1).getNumericCellValue();

	                 //int end_sem =(int) row.getCell(3).getNumericCellValue();
	                 //int credits =(int) row.getCell(4).getNumericCellValue();

	                 String sql = "update sem_1 set "+course+" = ? where  CNo= ?";
	                 PreparedStatement ps =  con.prepareStatement(sql);
	                 ps.setInt(1, marks);
	                 ps.setString(2, CNo);
	                 added= ps.executeUpdate();
	                 System.out.println("Import rows " + i);
	             }
	          
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
	
}

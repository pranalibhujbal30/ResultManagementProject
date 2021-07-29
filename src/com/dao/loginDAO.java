package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.connections.MyConnection;
import com.pojo.LoginBean;

public class loginDAO {
	
     public static boolean validate(LoginBean loginbean)
     {

 		Connection con = new MyConnection().getConnection();
 		boolean status =false;
 		
 		String sql="select * from user where username=? and password=?";
 		
 		PreparedStatement ps;
 		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, loginbean.getUsername());
			ps.setString(2, loginbean.getPassword());
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
    	 
    	 return status;
     }
     
     public static boolean validateStudent(String username,String password)
     {

 		Connection con = new MyConnection().getConnection();
 		boolean status =false;
 		
 		String sql="select * from Student where CNo=? and password=?";
 		
 		PreparedStatement ps;
 		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
 		
    	 
    	 return status;
     }


}

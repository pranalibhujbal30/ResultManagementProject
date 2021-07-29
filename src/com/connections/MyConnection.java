package com.connections;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
    
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/erms", "root", "mysql");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return connection;
	}

}

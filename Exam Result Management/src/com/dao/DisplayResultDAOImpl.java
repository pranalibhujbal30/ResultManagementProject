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
import com.pojo.Result;

/**
 * @author janhavi
 *
 */
public class DisplayResultDAOImpl implements DisplayResultDAO{
	@Override
	public List<Result> getStudentResult(String id){
		List<Result> resultList = new ArrayList<>();

		try {

			Connection connection = new MyConnection().getConnection();
			String sql = "select * from result";
			Statement statement =  connection.createStatement();
			ResultSet set = statement.executeQuery(sql);
			while (set.next()){
				resultList.add(new Result(set.getString(1), set.getString(2), set.getInt(3), set.getInt(4), set.getInt(5)));
			}
			connection.commit();
			connection.close();
			System.out.println("Success import excel to mysql table");
		} catch (SQLException e) {
			// TODO Auto-geOnerated catch block
			e.printStackTrace();
		}

		return resultList; 
	}

}

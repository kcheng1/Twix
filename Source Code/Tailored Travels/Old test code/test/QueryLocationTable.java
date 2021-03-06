package com.twix.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryLocationTable {
	public static final String url = "jdbc:derby:Database;create = true";
	public static final String queryStatement = "select * from db_waypoints";
	public static void main(String[] args) throws SQLException
	{
		Connection connect = DriverManager.getConnection(url);
		Statement statement = connect.createStatement();
		//query the user location table
		ResultSet resultSet = statement.executeQuery(queryStatement);
		ResultSetMetaData metaData = resultSet.getMetaData();
		int count = metaData.getColumnCount();
		for(int i = 1; i <= count; i++) System.out.format("%20s |", metaData.getColumnName(i));
		while(resultSet.next())
		{
			//prints all the location in a readable format
			System.out.println();
			for(int i = 1; i < count;i++) System.out.format("%20s |", resultSet.getString(i));
			System.out.format("%-300s", resultSet.getString(count));
		}
		if(statement != null)
			statement.close();
		if(connect != null)
			statement.close();
	}
}

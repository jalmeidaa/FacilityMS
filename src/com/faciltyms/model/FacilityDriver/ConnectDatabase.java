package com.faciltyms.model.FacilityDriver;
import java.sql.*;

// Connection String for the JDBC
// We are using MAMP server
// Database name is csc_473

public class ConnectDatabase {
	public static Connection connect()
	{
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:8888/MAMP/csc_473";
			String user = "root";
			String pass = "root";
			conn = DriverManager.getConnection(url,user,pass);
		} catch (SQLException se) {
			se.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}

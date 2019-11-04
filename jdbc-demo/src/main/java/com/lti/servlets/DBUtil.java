package com.lti.servlets;

import java.sql.*;

public class DBUtil {
	private static final String url = "jdbc:oracle:thin:@192.168.100.86:1521/xe";
	private static final String user = "hr";
	private static final String pass="hr";
	
	private DBUtil() { }
	
	public static Connection getConnection() 
		throws SQLException, ClassNotFoundException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		return DriverManager.getConnection(url,user,pass);
	}
	
	
	public static void close(Connection con) {
		try {
			con.close();
		}catch(Exception ex) {
			System.out.println("Unable to close connection, may be its not OPEN !");
			ex.printStackTrace();
		}
	}
}

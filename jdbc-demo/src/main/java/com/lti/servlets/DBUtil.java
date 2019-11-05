package com.lti.servlets;

import java.sql.*;
import java.util.Properties;

public class DBUtil {
	//Collection of properties
	
	private static  String url ;
	private static  String user; 
	private static  String pass;
	
	// Try to get value from db.properties if not found then use default values
	/// dbProps.getProperty("key","defaultValue");
	//  returns "defaultValue" when "key" is NULL
	static { 
		Properties dbProps = new Properties();
		try {
		dbProps.load(DBUtil.class.getResourceAsStream("/db.properties"));
		url = dbProps.getProperty("url");
		user = dbProps.getProperty("username");
		pass = dbProps.getProperty("password");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
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

package com.h2k.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;



public class DBUtil {
	
	private static String connectionString = "jdbc:mysql://localhost:3306/sakila";
	private static String userid = "root";
	private static String password = "password";
	
	
	public static Connection getConnection() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup ("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
		return ds.getConnection();
	}
	
	public static String getCompanyName() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup ("java:/comp/env");
		String company = (String) envContext.lookup("companyName");
		return company;
	}
	
	
	public static Connection getJDBCConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver"); // reflection method
		Connection conn = DriverManager.getConnection(connectionString, userid, password);
		if(conn != null) {
			System.out.println("You have created a connection successfully");
		}
		return conn;
	}
	
	
	public static void closeConnection(Connection conn) throws SQLException {
		if(conn != null) {
			conn.close();
			System.out.println("You have closed the connection successfully");
		}
	}
	
	

}

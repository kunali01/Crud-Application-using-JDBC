package com.crud.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static Connection conn;
	public static Connection getConnect() throws SQLException, ClassNotFoundException {
		String url = "jdbc:mysql://localhost:3306/bikeshowroomdb";
		String username = "root";
		String password = "root";
		conn = DriverManager.getConnection(url, username, password);
		return conn;
	}

}

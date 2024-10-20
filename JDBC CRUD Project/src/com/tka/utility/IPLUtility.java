package com.tka.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class IPLUtility {

	public static Connection getConnection() {

		String path = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/iplplayermanagement";
		String uname = "root";
		String pswd = "root";
		
		Connection connection = null;
		try {
			Class.forName(path);
			connection = DriverManager.getConnection(url, uname, pswd);
		

		} catch (Exception e) {
			e.printStackTrace();
		}

		return connection;
	}
}

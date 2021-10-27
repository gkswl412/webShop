package com.kosta.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	
	public static void dbClose(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			System.out.println("자원반납실패");
			e.printStackTrace();
		}
	}
	
	public static Connection dbConnect(String path) {
		//DB연결
		Connection conn = null;
		String url,userid,password;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Properties pro = new Properties();
			path += "\\WEB-INF\\dbinfo.properties";
			pro.load(new FileReader(path));
			url = pro.getProperty("url");
			userid = pro.getProperty("userid");
			password = pro.getProperty("password");
			conn = DriverManager.getConnection(url,userid,password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}

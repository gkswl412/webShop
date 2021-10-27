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

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil2 {
	
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
	
	public static Connection dbConnect() {
		//DB연결...Connection Pooling 기능을 이용해 연결 : 서버가 미리 디비 연결을 해놓음으로써 속도를 올린다.
		Context initContext;
		Connection conn = null;
		try {
			initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
			conn = ds.getConnection();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

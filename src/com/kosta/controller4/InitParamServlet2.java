package com.kosta.controller4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitParamServlet
 */
@WebServlet(urlPatterns = {"/InitParamServlet2"},
			initParams = {@WebInitParam( name = "tel" , value="010-1234-5678"),
						  @WebInitParam( name = "address" , value="kimpo")}
			)
public class InitParamServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = getServletContext();
		String driver = app.getInitParameter("driver");
		String userid = app.getInitParameter("userid");
		String userpass = app.getInitParameter("userpass");
		String tel = getInitParameter("tel");
		String address = getInitParameter("address");
		
		System.out.println(driver);
		System.out.println(userid);
		System.out.println(userpass);
		System.out.println(tel);
		System.out.println(address);
		
		//파일 읽기
		InputStream is = app.getResourceAsStream("/WEB-INF/dbinfo.properties");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String str;
		while((str = br.readLine())!=null) {
			System.out.println(str);
		}
		br.close();
		is.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

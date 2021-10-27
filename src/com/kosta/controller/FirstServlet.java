package com.kosta.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
//이 부분이 수정됨
//서버가 시작될때 @을 해석함 '유저가 뭐라고 요청했니?' / 빠져있으면 서버 시작할때 에러
@WebServlet({ "/LoginServlet", "/first", "/monday/one" })
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
    	System.out.println("LoginServlet 생성자");
        //super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("LoginServlet init (초기화)");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("LoginServlet 소멸");
	}


	/*
	 * protected void service(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * System.out.println("LoginServlet service"); }
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("myname");
		System.out.println("LoginServlet doGet" + name);
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.getWriter().append("Served at: ")
		.append(request.getContextPath())
		.append("<h1>" + name + "</h1>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginServlet doPost");
	}

}

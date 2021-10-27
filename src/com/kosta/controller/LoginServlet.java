package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/html/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		getData(request,response);
	}


	private void getData(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("아 이디는 " + id + "<br>");
		out.print("비 밀번호는 " + pw);
	}

}

package com.kosta.controller5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		//세션 데이터 삭제 ---> 로그아웃에 쓰임
		
		String path = request.getServletContext().getContextPath();
		response.sendRedirect(path);
	}



}

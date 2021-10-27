package com.kosta.controller3;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpService;
import com.kosta.model.EmployeeVO;
import com.kosta.model.Member2VO;

@WebServlet("/emp/emplist")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.request
		String data1 = (String) request.getAttribute("data1");
		//2.session
		HttpSession session = request.getSession();
		
		//세션에 저장된 멤버가 없다면 로그인 안한것
		//로그인 없이는 직원정보보기 불가 구현 하고 싶음.
		/*
		 * Object obj = session.getAttribute("member"); if(obj==null) {
		 * System.out.println("로그인후 이용해주세요.");
		 * response.sendRedirect("../pro09/memberlogin"); return; }
		 */
		
		String data2 = (String) session.getAttribute("data2");
		//3.application
		ServletContext application = getServletContext();
		String data3 = (String) application.getAttribute("data3");
		
		System.out.println(data1);
		System.out.println(data2);
		System.out.println(data3);
		
		String user_id = (String) session.getAttribute("user_id");
		String user_pw = (String) session.getAttribute("user_pw");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
		String email = (String) session.getAttribute("email");
		System.out.println(user_id);
		System.out.println(user_pw);
		System.out.println(phone);
		System.out.println(address);
		System.out.println(email);
		

		EmpService service = new EmpService();
		request.setAttribute("emplist", service.selectAll());
		//EL문법 ==> ${emplist}
		//ScriptLet문법==> (List<EmployeeVO>)request.getAttribute("emplist")
		//JSTL문법==>tag이용 <forEach items="$...
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);
	}
	
	//바인딩: 서블릿 관련 객체에 데이터를 저장
	//application(웹프로그램당) ....ServletContext 객체 .... 서버가 살아있는 동안 유효
	//session(browser당) ....HttpSession 객체 ....브라우저가 살아있는 동안 유효(로그인 한 동안 유저정보를 유지해야 하는 경우)
	//request(요청문서) ....HttpServletRequest 객체 ....request가 살아있는 동안 유효


}

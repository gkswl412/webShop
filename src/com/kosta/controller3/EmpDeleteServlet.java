package com.kosta.controller3;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.EmpService;
import com.kosta.model.EmployeeVO;
import com.kosta.util.DateUtil;

@WebServlet("/emp/empdelete")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//직원 정보 삭제
		int empid = Integer.parseInt(request.getParameter("empid")); 
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		String message = result>0?"삭제성공":"삭제실패";
		response.setCharacterEncoding("utf-8"); //한글 인코딩 안됨.. 왜그러지?
		response.sendRedirect("emplist?message=" + message);
		
		
		//request.setAttribute("message",service.empDelete(empid)>0?"삭제성공":"삭제실패"); 
		//RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		//response.addHeader("Refresh", "1; emplist");
		//rd.forward(request, response);
		
	}

	

}

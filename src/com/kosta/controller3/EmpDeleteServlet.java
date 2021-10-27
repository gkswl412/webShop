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
		//���� ���� ����
		int empid = Integer.parseInt(request.getParameter("empid")); 
		EmpService service = new EmpService();
		int result = service.empDelete(empid);
		String message = result>0?"��������":"��������";
		response.setCharacterEncoding("utf-8"); //�ѱ� ���ڵ� �ȵ�.. �ֱ׷���?
		response.sendRedirect("emplist?message=" + message);
		
		
		//request.setAttribute("message",service.empDelete(empid)>0?"��������":"��������"); 
		//RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		//response.addHeader("Refresh", "1; emplist");
		//rd.forward(request, response);
		
	}

	

}

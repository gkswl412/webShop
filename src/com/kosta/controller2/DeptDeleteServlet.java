package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptService;


@WebServlet("/dept/deptdelete")
public class DeptDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String deptid = request.getParameter("deptid");
		if(deptid==null) {
			return;
		}
		int i_deptid = Integer.parseInt(deptid);
		
		String path = getServletContext().getRealPath(".");
		DeptService service = new DeptService(path);
		int result = service.deleteService(i_deptid);
		request.setAttribute("message", result>0?"삭제 성공":"삭제 실패");
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}

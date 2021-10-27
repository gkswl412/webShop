package com.kosta.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kosta.model.DeptDTO;
import com.kosta.model.DeptService;

@WebServlet("/dept/deptinsert")
public class DeptInserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//입력form보여주기
		RequestDispatcher rd = request.getRequestDispatcher("deptinsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int deptId = Integer.parseInt(request.getParameter("department_id"));
		String deptName = request.getParameter("department_name");
		int mgId = Integer.parseInt(request.getParameter("manager_id"));
		int locId = Integer.parseInt(request.getParameter("location_id"));
		String path = getServletContext().getRealPath(".");
		DeptDTO dept = new DeptDTO(deptId,deptName,mgId,locId);
		DeptService service = new DeptService(path);
		int result = service.insertService(dept);
		request.setAttribute("message", result>0?"등록 성공":"등록 실패");
		RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	}

}

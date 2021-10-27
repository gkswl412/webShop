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
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpService;
import com.kosta.model.EmployeeVO;
import com.kosta.util.DateUtil;

@WebServlet("/emp/empdetail")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인 하지 않으면 업무불가
		/*
		 * HttpSession session = request.getSession(); Object obj =
		 * session.getAttribute("member"); if(obj == null) {
		 * System.out.println("로그인하지 않으면 업무 불가");
		 * response.sendRedirect("../html/loginPost"); return; }
		 */
		
		// 직원 정보 상세보기
		int empid = Integer.parseInt(request.getParameter("empid"));
		EmpService service = new EmpService();
		request.setAttribute("emp", service.selectByEmpid(empid));
		RequestDispatcher rd = request.getRequestDispatcher("empdetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EmployeeVO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empUpdate(emp);
		
		request.setAttribute("message", result>0?"수정성공":"수정실패");
		response.addHeader("Refresh", "1;url=emplist"); 
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp"); 
		rd.forward(request, response);
		 
		// response.sendRedirect("emplist"); //서블릿으로 요청 보내기
		// 다시요청한다. 요청재지정하기 주소창이 바뀐다.
	}

	private EmployeeVO makeEmp(HttpServletRequest request) throws UnsupportedEncodingException {
		//request.setCharacterEncoding("utf-8");
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		String last_name = request.getParameter("last_name");
		String first_name = request.getParameter("first_name");
		int department_id = Integer.parseInt(request.getParameter("department_id"));
		String job_id = request.getParameter("job_id");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		int manager_id = Integer.parseInt(request.getParameter("manager_id"));
		double commission_pct = Double.parseDouble(request.getParameter("commission_pct"));
		int salary = Integer.parseInt(request.getParameter("salary"));
		Date hire_date = DateUtil.convertToDate(request.getParameter("hire_date"));

		EmployeeVO emp = new EmployeeVO();
		emp.setCommission_pct(commission_pct);
		emp.setDepartment_id(department_id);
		emp.setEmail(email);
		emp.setEmployee_id(employee_id);
		emp.setFirst_name(first_name);
		emp.setHire_date(hire_date);
		emp.setJob_id(job_id);
		emp.setLast_name(last_name);
		emp.setManager_id(manager_id);
		emp.setPhone_number(phone_number);
		emp.setSalary(salary);
		return emp;
	}

}

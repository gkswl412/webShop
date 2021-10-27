package com.kosta.controller3;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.DeptService;
import com.kosta.model.EmpService;
import com.kosta.model.EmployeeVO;
import com.kosta.model.JobService;
import com.kosta.util.DateUtil;

@WebServlet("/emp/empinsert")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//직원 신규등록
		
		/*
		 * HttpSession session = request.getSession(); Object obj =
		 * session.getAttribute("member"); if(obj == null) {
		 * System.out.println("로그인하지 않으면 업무 불가");
		 * response.sendRedirect("../html/loginPost"); return; }
		 */
		
		String path = getServletContext().getRealPath(".");
		DeptService service = new DeptService(path);
		JobService service2 = new JobService();
		EmpService service3 = new EmpService();
		request.setAttribute("joblist", service2.selectAll());
		request.setAttribute("deptlist", service.selectAllService());
		request.setAttribute("mlist", service3.selectAllManager());
		
		RequestDispatcher rd = request.getRequestDispatcher("empinsert.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("utf-8");
		EmployeeVO emp = makeEmp(request);
		EmpService service = new EmpService();
		int result = service.empInsert(emp);
		//1.Dispatcher이용 .... 주소창이 변경없음
		//request.setAttribute("message", result>0?"등록성공":"등록실패");
		//RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
		//rd.forward(request, response);
		
		//2.redirect ...주소창이 바뀐다.
		response.sendRedirect("emplist?message=insert success");
	}

	private EmployeeVO makeEmp(HttpServletRequest request) {
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

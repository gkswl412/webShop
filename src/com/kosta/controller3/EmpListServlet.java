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
		
		//���ǿ� ����� ����� ���ٸ� �α��� ���Ѱ�
		//�α��� ���̴� ������������ �Ұ� ���� �ϰ� ����.
		/*
		 * Object obj = session.getAttribute("member"); if(obj==null) {
		 * System.out.println("�α����� �̿����ּ���.");
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
		//EL���� ==> ${emplist}
		//ScriptLet����==> (List<EmployeeVO>)request.getAttribute("emplist")
		//JSTL����==>tag�̿� <forEach items="$...
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);
	}
	
	//���ε�: ���� ���� ��ü�� �����͸� ����
	//application(�����α׷���) ....ServletContext ��ü .... ������ ����ִ� ���� ��ȿ
	//session(browser��) ....HttpSession ��ü ....�������� ����ִ� ���� ��ȿ(�α��� �� ���� ���������� �����ؾ� �ϴ� ���)
	//request(��û����) ....HttpServletRequest ��ü ....request�� ����ִ� ���� ��ȿ


}

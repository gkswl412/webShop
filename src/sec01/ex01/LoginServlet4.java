package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pro09/login")
public class LoginServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//서버 시작시 맨 처음 요청때만 발생
	public void init() {
		System.out.println("LoginServlet4 init 메서드 호출");
	}
	//브라우저 주소창에서 엔터치면 get요청임!!!
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");

		String data = "안녕하세요!<br> 로그인하셨습니다.<br><br>";
		data += "<html><body>";
		data += "아이디 : " + user_id;
		data += "<br>";
		data += "비밀번호 : " + user_pw;
		data += "<br>";
		data += "주소 : " + user_address;
		data += "<br>";
		data += "email : " + user_email;
		data += "<br>";
		data += "휴대 전화 : " + user_hp;
		data += "</html></body>";
		out.print(data);
	}
	//서버 중단시 발생
	public void destroy() {
		System.out.println("LoginServlet4 destroy 메서드 호출");
	}
}

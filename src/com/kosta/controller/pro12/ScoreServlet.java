package com.kosta.controller.pro12;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/pro12/scoreResultServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int score = Integer.parseInt(request.getParameter("score"));
		String output = "";
		if(score>=90){
				output = "A학점";
			 }else if(score>=80 && score<90){
				 output = "B학점";  
			   }else if(score>=70 && score<80){
				   output = "C학점";			
			   }else if(score>=60 && score<70){
				   output = "D학점";   
			   }else{
				   output = "F학점";
			   }
		request.setAttribute("scoreResult", output);
		RequestDispatcher rd = request.getRequestDispatcher("scoretest.jsp");
		rd.forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

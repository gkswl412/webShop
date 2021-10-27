package com.kosta.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/emp/*")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        System.out.println("loginFilter 생성자");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("loginFilter 소멸");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//HttpServletRequest는 ServletRequest를 상속받아 만든 객체이므로
		//거꾸로 cast형변환 가능
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse rep = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("member");
		if(obj == null) {
			System.out.println("로그인하지 않으면 업무 불가");
			rep.sendRedirect("../html/loginPost");
			return;
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

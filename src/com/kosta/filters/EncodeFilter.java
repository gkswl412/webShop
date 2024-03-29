package com.kosta.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncodeFilter() {
        System.out.println("EncodeFilter 생성자");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
        System.out.println("EncodeFilter destroy");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//요청 가기전
		long start = System.currentTimeMillis();
		System.out.println("요청가기전");
		request.setCharacterEncoding("utf-8");
		chain.doFilter(request, response);
		//응답하기전
		long end = System.currentTimeMillis();
		System.out.println("응답하기전");
		System.out.println(end-start);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

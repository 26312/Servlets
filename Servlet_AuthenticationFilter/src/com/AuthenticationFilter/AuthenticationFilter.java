package com.AuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/loginservlet")
public class AuthenticationFilter implements Filter {

  
 	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(name.equals("Varun")&&password.equals("admin123")) {
			chain.doFilter(request, response);
		}else {
			out.println("Invalide username and password!!");
		}
		
		
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}

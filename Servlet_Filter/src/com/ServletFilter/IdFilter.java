package com.ServletFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;


@WebFilter("/myservlet")
public class IdFilter implements Filter {


  
	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		
		PrintWriter out = response.getWriter();
		
		
		int id = Integer.parseInt(request.getParameter("id"));
				
		if(id>1) {
			chain.doFilter(request, response);
			}else{
				out.println("Invalid Entry!!");
		}
		
		
		// pass the request along the filter chain
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

package com.ServletAnnotation;

// Exmaple Program For Servlet Annotation with ServletContext & ServletConfig

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAnnotation")
public class ServletAnnotation extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int i =  Integer.parseInt(request.getParameter("t1"));
		int j =  Integer.parseInt(request.getParameter("t2"));
		
		int k = i+j;
		
		Cookie cookies = new Cookie("k", k + "");
		response.addCookie(cookies);
		
		response.sendRedirect("ServletAnnotation2");
		
		
	}
	

}

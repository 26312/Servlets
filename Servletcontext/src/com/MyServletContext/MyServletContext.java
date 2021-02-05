package com.MyServletContext;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServletContext extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		out.print("Hello ");
		
		
		
		ServletContext ctx = request.getServletContext(); /* The TomaCat server gives the object of ServletContext 
														  at the time of application deployment 
														  we get access to that object by using 'getServletContext'
														  which we are getting from HttpServlet because HttpServlet extends genric servlets	
														*/
		
		String str = ctx.getInitParameter("name"); // gives value of the attribute which 
		out.print(str);
		
		String str2 = ctx.getInitParameter("phone");
		out.print("\n Your mobile model is: " + str2);
				
	}

}

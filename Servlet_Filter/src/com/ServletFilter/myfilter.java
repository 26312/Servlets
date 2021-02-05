package com.ServletFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/myservlet")
public class myfilter extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		
		out.println("Welcome " + name + " to Servlet Filter Session <br>");
		
		out.println(name + " Your ID is : " + id);
		
		
		
	}

}

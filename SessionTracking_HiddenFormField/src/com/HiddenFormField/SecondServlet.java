package com.HiddenFormField;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SecondServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		
		out.println("<center> Name is : " + name + "</center>");
		out.println("<center> Password is : " + password + "</center>");
		out.println("<center> Email is : " + email + "</center>");
		out.println("<center> Mobile is : " + mobile + "</center>");
		
		
	}
}

package com.HiddenFormField;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FirstServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		 response.setContentType("text/html");  
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		out.println("<form action='SecondServlet' method='post'>");
		out.println("Enter Email: <input type='text' name='email'/><br>");
		out.println("Enter mobile: <input type='text' name='mobile'/><br>");
		out.println("<input type='hidden' value="+ name +" name='name'/>");
		out.println("<input type='hidden' value=" + password +" name='password'/>");
		out.println("<input type='submit' value='Go'/>");
		out.println("</form>");
		
		
		
	}

}

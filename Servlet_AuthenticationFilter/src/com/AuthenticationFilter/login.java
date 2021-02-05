package com.AuthenticationFilter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class login extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)  {
		
		
		response.setContentType("text/html");
try {
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		
		out.println("<br><br>Welcome " + name + " You have logged in successfully");
		
				
		}catch(IOException ex) {
			System.out.println(ex);
		}
		
		
		
		
	}

}

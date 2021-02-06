package com.CookiesInServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
			PrintWriter out = response.getWriter();
			
			request.getRequestDispatcher("link.html").include(request, response);
		
				String name = request.getParameter("t1");
				String password = request.getParameter("t2");
				
				if(password.equals("admin123")) {
				
					out.println("<br><br>Logged in Successfully");
					out.println("<br><br>Welcome " + name);
					
					Cookie cookies = new Cookie("name", name);
					response.addCookie(cookies);
				}else{				
					out.println("<br><br>Invalid Credentials");
					request.getRequestDispatcher("login.html").include(request, response);
					
									
				}
				out.close();
				
		
	}

}

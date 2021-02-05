package com.CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateDetail")
public class updateDetails extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text.html");
		
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee e = new Employee();
		
		e.setId(id);
		e.setName(name);
		e.setPassword(password);
		e.setEmail(email);
		e.setCountry(country);
		
		int result = EmployeeDAO.update(e);
		
		if(result>0) {
			
			response.sendRedirect("viewServlet");
		}else {
			System.out.println("Sorry! unable to update record");
		}
		
		
		
	}

}

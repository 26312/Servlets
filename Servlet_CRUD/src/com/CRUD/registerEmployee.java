package com.CRUD;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resgister")
public class registerEmployee extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		EmployeeDAO empdao = new EmployeeDAO();
		
		int id =  Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		Employee emp = new Employee();
		
		emp.setId(id);
		emp.setName(name);
		emp.setPassword(password);
		emp.setEmail(email);
		emp.setCountry(country);
		
		int result = empdao.registerEmployee(emp);
			if(result>0) {
				System.out.println("Record Saved Successfully");
				response.sendRedirect("index.html");
			}else {
				System.out.println("Invalid Entry!!");
				request.getRequestDispatcher("index.html").include(request, response);  
			}
		
		
	}

}

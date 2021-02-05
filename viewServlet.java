package com.CRUD;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		List<Employee> list = EmployeeDAO.getAllEmployees(); 
		
		out.println("<h4><u><b>Employee Details</b></u></h4>");
		
		out.print("<table border = '1' width='100%'");
		
		out.println("<tr><th>ID</th><th>Name</th><th>Password</th><th>Email</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		
		for(Employee e:list) {
			
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td><td>" + e.getEmail() + "</td><td>" + e.getCountry() + 
					"</td><td> <a href='editServlet?id="+ e.getId() +"'>Edit </a></td> <td><a href='deleteServlet?id="+ e.getId() +"'>Delete</a></th></tr>" );
			
			
		}
		out.print("</table>");
		
		out.println("<a href='index.html'> Add New Employee </a>");
		
		
		
	}

}

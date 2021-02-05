package com.CRUD;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		EmployeeDAO.delete(id);
		
		response.sendRedirect("viewServlet");
		
		
	}

}

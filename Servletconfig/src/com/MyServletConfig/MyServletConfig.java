package com.MyServletConfig;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class MyServletConfig extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException {
		
		PrintWriter out = response.getWriter();
		out.print("Howdy!!  ");
		
		
		ServletConfig cfg = getServletConfig();
		String str = cfg.getInitParameter("name");
		
		out.print("There " + str);
		
		
		
	}

}

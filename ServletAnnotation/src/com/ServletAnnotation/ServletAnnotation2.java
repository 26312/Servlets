package com.ServletAnnotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletAnnotation2")
public class ServletAnnotation2 extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		int k=0;
		
		Cookie cookies[] = request.getCookies();
		for(Cookie c : cookies) {
			
			if(c.getName().equals("k")) {
				
				k =  Integer.parseInt(c.getValue())  ;
			}
		}
		
		k = k * k;
		
		
		PrintWriter out = response.getWriter();
		out.println("Result is:" + k);
	}
	

}

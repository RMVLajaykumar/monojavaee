package com.monocept.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("inside method");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String firstname=request.getParameter("firstname");
		response.setContentType("text/html");
		ServletContext context = getServletContext();
		String initParameter = context.getInitParameter("totalEmployee");
		PrintWriter out = response.getWriter();
		out.println("<Html>");
		out.println("<Head>");
		out.println("<title> test servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>Hello"+initParameter+"</h2>");
		out.println("</body>");
		out.println("</Html>");
		
				
		
	}

	

}

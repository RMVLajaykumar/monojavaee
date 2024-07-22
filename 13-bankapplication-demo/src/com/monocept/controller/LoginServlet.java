package com.monocept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.monocept.database.CustomerDao;
import com.monocept.entity.Customer;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
         protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	      throws ServletException, IOException {
    	    request.getRequestDispatcher("/login.jsp").forward(request, response);
    	  }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (password != null && username != null) {
			try {
				if (CustomerDao.validateAdmin(username,password)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("role", "Admin");
					response.sendRedirect("admin");
				} else if (CustomerDao.validateCustomer(username, password)) {
					HttpSession session = request.getSession();
					session.setAttribute("username", username);
					session.setAttribute("role", "User");
					response.sendRedirect("user");
				} else {
					response.sendRedirect("login.jsp?error=true");
				}
			} catch (IOException e) {
				System.out.println(e);
			}
		}
    }
}

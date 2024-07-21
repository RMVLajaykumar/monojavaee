package com.monocept.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.monocept.dao.CustomerDao;
import com.monocept.entry.Account;
import com.monocept.entry.Customer;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public CustomerDao customerDAO = new CustomerDao();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String  command;
		command=request.getParameter("command");
		
		if(command==null) {
			command="list";
		}
		
		System.out.println(command);
		
		switch(command) {
		case "search":
			search(request,response);
			break;
		default :
        MapCustomers(request,response);
    }
    }


    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int customerId= Integer.parseInt(request.getParameter("customer_id"));
       CustomerDao customerDao = new CustomerDao();
       java.util.Map<Customer, Account> customers = customerDao.searchCustomersWithAccounts(customerId);
       
       System.out.println(customers);

      
       request.setAttribute("customersList", customers);

       
       request.getRequestDispatcher("/view-customers.jsp").forward(request, response);
       
       
    	
		
	}


	private void MapCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	
    	 CustomerDao customerDao = new CustomerDao();
         java.util.Map<Customer, Account> customers = customerDao.getAllCustomersWithAccounts();
         
         System.out.println(customers);

        
         request.setAttribute("customersList", customers);

         
         request.getRequestDispatcher("/view-customers.jsp").forward(request, response);
		
	}


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addCustomer(request, response);
        } else {
            response.sendRedirect("error.jsp");
        }
    }

    private void addCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName = request.getParameter("customer-fname");
        String lastName = request.getParameter("customer-lname");
        String email = request.getParameter("customer-email");
        String password = request.getParameter("customer-password");

        Customer newCustomer = new Customer(0, firstName, lastName, email, password);
        boolean success = customerDAO.addCustomer(newCustomer);

        if (success) {
            response.sendRedirect("admin"); 
        } else {
            response.sendRedirect("add-new-customer.jsp?error=true");
        }
    }

}

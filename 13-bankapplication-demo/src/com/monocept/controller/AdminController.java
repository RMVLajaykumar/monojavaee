package com.monocept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monocept.database.CustomerDao;
import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.entity.Transaction;
import com.sun.javafx.collections.MappingChange.Map;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
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
		case "viewCustomer":
           MapCustomers(request,response);
          break;
		case "addCustomer" :
			 showAddCustomerPage(request,response);
		 break;
		case "adminhome":
			adminHome(request,response);
			break;
		case "searching":
			try {
				searchingTransaction(request,response);
				
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			break;
		case "transaction":
			trasaction(response,request);
			break;
		case "add":
			addCustomer(request,response);
		default :
        adminHome(request,response);
			}
    }


    private void adminHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin.jsp");
		requestDispatcher.forward(request, response);
		
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
	
	  private void showAddCustomerPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("add-new-customer.jsp");
	        dispatcher.forward(request, response);
	  }


	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String action = request.getParameter("action");
//
//        if ("add".equals(action)) {
//            addCustomer(request, response);
//        } else {
//            response.sendRedirect("error.jsp");
//        }
		doGet(request, response);
    }
	private void searchingTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	    String searchCriteria = request.getParameter("searchBy"); // Update to match the JSP field name
	    String senderAccountNumberStr = request.getParameter("sender_account_number");
	    String receiverAccountNumberStr = request.getParameter("receiver_account_number");
	    String fromDate = request.getParameter("start_date"); // Update to match the JSP field name
	    String toDate = request.getParameter("end_date"); // Update to match the JSP field name

	    Integer senderAccountNumber = senderAccountNumberStr != null && !senderAccountNumberStr.isEmpty() ? Integer.parseInt(senderAccountNumberStr) : null;
	    Integer receiverAccountNumber = receiverAccountNumberStr != null && !receiverAccountNumberStr.isEmpty() ? Integer.parseInt(receiverAccountNumberStr) : null;

	    CustomerDao customerDao = new CustomerDao();
	    List<Transaction> transactions;

	    if ("account".equals(searchCriteria)) {
	        transactions = customerDao.searchTransactions(senderAccountNumber, receiverAccountNumber, null, null);
	    } else if ("date".equals(searchCriteria)) {
	        transactions = customerDao.searchTransactions(null, null, fromDate, toDate);
	    } else {
	        transactions = new ArrayList<>(); // In case of no matching criteria, return an empty list
	    }

	    request.setAttribute("transactionsList", transactions);
	    request.getRequestDispatcher("/view-transactions.jsp").forward(request, response);
	}


	private void trasaction(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		
		try {
			CustomerDao customerDao = new CustomerDao();
			 List<Transaction> transactions = customerDao.getTransactions();
			 System.out.println(transactions);
			 request.setAttribute("transactionsList", transactions);
			 request.getRequestDispatcher("/view-transactions.jsp").forward(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
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
        	System.out.println("df");
           RequestDispatcher requestDispatcher = request.getRequestDispatcher("admin?command=list");
           requestDispatcher.forward(request, response);
        } else {
        	System.out.println("fdsd");
            response.sendRedirect("add-new-customer.jsp?error=true");
        }
    }

}

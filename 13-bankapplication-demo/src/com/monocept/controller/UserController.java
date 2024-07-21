package com.monocept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.monocept.dao.CustomerDao;
import com.monocept.entry.Customer;
import com.monocept.entry.Transaction;

@WebServlet("/user")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @Resource(name="jdbc/bank")
    private DataSource datasource;
    private CustomerDao customerDao;
    
    @Override
	public void init() throws ServletException {
		customerDao = new CustomerDao(datasource);
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		if (command != null) {
			try {
				switch (command) {
					case "passbook":
						viewPassbook(request, response);
						break;
					case "newtransaction":
						 newTransaction(request,response);
						 break;
					case "editProfile":
						editProfile(request,response);
						break;
					
					default:
						showUserPage(request, response);
						break;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new ServletException(e);
			}
		} else {
			
			showUserPage(request, response);
		}
    }
	private void editProfile(HttpServletRequest request, HttpServletResponse response)
		      throws SQLException, ServletException, IOException {

		    HttpSession session = request.getSession();

		    String email = (String) session.getAttribute("username");
		    System.out.println("Emial"+email);
		    String f_name = request.getParameter("first_name");
		    String l_name = request.getParameter("last_name");
		    String pass = request.getParameter("password");
		    Customer customer = new Customer(email, f_name, l_name, pass);
		    boolean isUpdate = customerDao.editProfile(customer);
		    if (isUpdate) {
		      System.out.println("updated");
		    } else {
		      System.out.println("no update");
		    }
             
		    RequestDispatcher dispatcher = request.getRequestDispatcher("edit-profile.jsp");
			dispatcher.forward(request, response);
		  }
	private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
	    HttpSession session = request.getSession();
	    String email = (String) session.getAttribute("username");
	    int receiverAccount = Integer.parseInt(request.getParameter("receiver_account_number"));
	    double amount = Double.parseDouble(request.getParameter("transaction_amount"));

	    System.out.println("Email: " + email);
	    System.out.println("Receiver Account: " + receiverAccount);
	    System.out.println("Amount: " + amount);

	    boolean success = customerDao.newTransaction(email, receiverAccount, amount);

	    if (success) {
	        System.out.println("Transaction successful.");
	        response.sendRedirect("transaction-success.jsp"); 
	    } else {
	        System.out.println("Transaction failed.");
	        response.sendRedirect("transaction-failure.jsp"); 
	    }
	}




	private void viewPassbook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("username");
		System.out.println(email);
		List<Transaction> transactions = customerDao.getPassbook(email);
		System.out.println(transactions);
		request.setAttribute("transactionsList", transactions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("passbook.jsp");
		dispatcher.forward(request, response);
	}

	private void showUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
		requestDispatcher.forward(request, response);
	}
}
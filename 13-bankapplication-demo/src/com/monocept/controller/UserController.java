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

import com.monocept.database.CustomerDao;
import com.monocept.entity.Customer;
import com.monocept.entity.Transaction;

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
                        showNewTransactionPage(request, response);
                        break;
                    case "editProfile":
                        editProfile(request, response);
                        break;
                    case "transactionSuccess":
                    	transactionSuccess(request, response);
                    	break;
                    case "transactionFailure":
                    	transactionFailure(request,response);
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

    private void transactionFailure(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher dispatcher = request.getRequestDispatcher("transaction-failure.jsp");
        dispatcher.forward(request, response);
		
	}

	private void transactionSuccess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("transaction-success.jsp");
        dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	
    	String command = request.getParameter("command");
        if ("newtransaction".equals(command)) {
            try {
                newTransaction(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
                throw new ServletException(e);
            }
        } else {
            // Handle other POST requests if necessary
            showUserPage(request, response);
        }
        if("editProfile".equals(command)) {
    	doGet(request, response);
        }
    }

    private void showNewTransactionPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("transaction.jsp");
        dispatcher.forward(request, response);
    }

    private void editProfile(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("username");
        String f_name = request.getParameter("first_name");
        String l_name = request.getParameter("last_name");
        String pass = request.getParameter("password");
        Customer customer = new Customer(email, f_name, l_name, pass);
        boolean isUpdate = customerDao.editProfile(customer);
        if (isUpdate) {
            System.out.println("Profile updated.");
        } else {
            System.out.println("Profile not updated.");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit-profile.jsp");
        dispatcher.forward(request, response);
    }

    private void newTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("username");
        String receiverAccountNumberStr = request.getParameter("receiver_account_number");
        String transactionAmountStr = request.getParameter("transaction_amount");

        if (email != null && receiverAccountNumberStr != null && !receiverAccountNumberStr.isEmpty() &&
            transactionAmountStr != null && !transactionAmountStr.isEmpty()) {
            int receiverAccountNumber = Integer.parseInt(receiverAccountNumberStr);
            double amount = Double.parseDouble(transactionAmountStr);

            System.out.println("Initiating transaction from " + email + " to account " + receiverAccountNumber + " with amount " + amount);

            boolean transactionImplementation = customerDao.newTransaction(email, receiverAccountNumber, amount);

            if (transactionImplementation) {
                System.out.println("Transaction successful.");
                response.sendRedirect(request.getContextPath() + "/user?command=transactionSuccess"); 
            } else {
                System.out.println("Transaction failed.");
                response.sendRedirect(request.getContextPath() + "/user?command=transactionFailure");
            }
        } else {
            System.out.println("Invalid transaction details.");
            response.sendRedirect(request.getContextPath() + "/user?command=newtransaction");
        }
    }

    private void viewPassbook(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("username");
        List<Transaction> transactions = customerDao.getPassbook(email);
        request.setAttribute("transactionsList", transactions);
        RequestDispatcher dispatcher = request.getRequestDispatcher("passbook.jsp");
        dispatcher.forward(request, response);
    }

    private void showUserPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("user.jsp");
        requestDispatcher.forward(request, response);
    }
}

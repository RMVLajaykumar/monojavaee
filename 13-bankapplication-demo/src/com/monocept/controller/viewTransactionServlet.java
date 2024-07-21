package com.monocept.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.monocept.dao.CustomerDao;
import com.monocept.entry.Customer;
import com.monocept.entry.Transaction;


@WebServlet("/viewTransactionServlet")
public class viewTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		
		String  command;
		command=request.getParameter("command");
		
		if(command==null) {
			command="list";
		}
		
		System.out.println(command);
		
		switch(command) {
		
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
		default:
			trasaction(response,request);
		}
		
		
		
        
		
        
	}


	private void searchingTransaction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		 int senderId= Integer.parseInt(request.getParameter("sender_account_number"));
		 int receiverId= Integer.parseInt(request.getParameter("receiver_account_number"));
		 CustomerDao customerDao = new CustomerDao();
		 List<Transaction> transactions = customerDao.SearchTransaction(senderId,receiverId);
		 System.out.println(transactions);
		 request.setAttribute("transactionsList", transactions);
		 request.getRequestDispatcher("/view-transactions.jsp").forward(request, response);
				 
		 
		 
		
	}


	private void trasaction(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException{
		// TODO Auto-generated method stub
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

	
	

}

package com.monocept.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.monocept.entity.Account;
import com.monocept.entity.Customer;
import com.monocept.entity.Transaction;




public class CustomerDao {

DataSource datasource;

    
    public CustomerDao(DataSource datasource2) {
		
    	this.datasource=datasource2;
	}

	public static boolean validateCustomer(String email, String password) {
        try (Connection connection = DataBaseUtil.getConnection();
        		) {
        	String VALIDATE_CUSTOMER_QUERY = "SELECT * FROM customer WHERE email_id = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(VALIDATE_CUSTOMER_QUERY);
            statement.setString(1, email);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public Map<Customer,Account> getAllCustomersWithAccounts() {
    	 Map<Customer,Account> customers = new HashMap<>();
        String query = "SELECT c.customer_id, c.first_name, c.last_name, a.account_number, a.balance " +
                       "FROM customer c JOIN accounts a ON c.customer_id = a.customer_id";

        try (Connection connection = DataBaseUtil.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                int customerId = resultSet.getInt("customer_id");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                int accountNumber = resultSet.getInt("account_number");
                double balance = resultSet.getDouble("balance");

                Customer customer = new Customer(customerId, firstName, lastName);
                Account account=new Account(accountNumber,balance);
                customers.put(customer, account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

   
    


    public boolean addCustomer(Customer customer) {
        try (Connection connection = DataBaseUtil.getConnection();
        		 ) {
        	String INSERT_CUSTOMER_QUERY = "INSERT INTO customer (first_name, last_name, email_id, password) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(INSERT_CUSTOMER_QUERY);

            statement.setString(1, customer.getFirst_name());
            statement.setString(2, customer.getLast_name());
            statement.setString(3, customer.getEmail());
            statement.setString(4, customer.getPassword());
            int rowsInserted = statement.executeUpdate();
            
            String query1="select * from customer where first_name=? and last_name=? and email_id=? and password=?";
            PreparedStatement state=connection.prepareStatement(query1);
            state.setString(1, customer.getFirst_name());
            state.setString(2, customer.getLast_name());
            state.setString(3, customer.getEmail());
            state.setString(4, customer.getPassword());
           ResultSet rs=state.executeQuery();
           
           int customerid=0;
           while(rs.next()) {
        	    customerid=rs.getInt("customer_id");
           }
           String insertQuery="insert into accounts(customer_id) values(?)";
   		  PreparedStatement preparedStatement1 = connection.prepareStatement(insertQuery);
   		  preparedStatement1.setInt(1, customerid);
   		  int executeUpdate2 = preparedStatement1.executeUpdate();
           
           
           
            return rowsInserted > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Transaction> getTransactions() throws SQLException {
		List<Transaction> transactions=new ArrayList<Transaction>();
		Connection connection = DataBaseUtil.getConnection();
		String selectQuery="select * from transactions";
		Statement createStatement = connection.createStatement();
		ResultSet executeQuery = createStatement.executeQuery(selectQuery);
		while(executeQuery.next()) {
			int sender=executeQuery.getInt("sender_account_number");
			int receiver=executeQuery.getInt("receiver_account_number");
			String date=executeQuery.getString("date_of_transaction");
			String type=executeQuery.getString("transaction_type");
			double amount=executeQuery.getDouble("transaction_amount");
			Transaction transaction=new Transaction(sender, receiver, date, type, amount);
			transactions.add(transaction);
			
		}
		return transactions;
	}

    public Map<Customer, Account> searchCustomersWithAccounts(int customerId) {
        Map<Customer, Account> customers = new HashMap<>();

        try {
            Connection conn = DataBaseUtil.getConnection();
            String query = "SELECT c.customer_id, c.first_name, c.last_name, a.account_number, a.balance FROM customer c JOIN accounts a ON c.customer_id = a.customer_id WHERE c.customer_id = ?";
            PreparedStatement state = conn.prepareStatement(query);

            state.setInt(1, customerId);
            ResultSet rs = state.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                int accountNumber = rs.getInt("account_number");
                double balance = rs.getDouble("balance");

                Customer customer1 = new Customer(id, firstName, lastName);
                Account account1 = new Account(accountNumber, balance);
                customers.put(customer1, account1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public List<Transaction> searchTransactions(Integer senderAccountNumber, Integer receiverAccountNumber, String fromDate, String toDate) {
        List<Transaction> transactions = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM transactions WHERE 1=1");
        
        if (senderAccountNumber != null) {
            query.append(" AND sender_account_number = ?");
        }
        if (receiverAccountNumber != null) {
            query.append(" AND receiver_account_number = ?");
        }
        if (fromDate != null && !fromDate.isEmpty()) {
            query.append(" AND date_of_transaction >= ?");
        }
        if (toDate != null && !toDate.isEmpty()) {
            query.append(" AND date_of_transaction <= ?");
        }

        try (Connection connection = DataBaseUtil.getConnection();
             PreparedStatement statement = connection.prepareStatement(query.toString())) {

            int paramIndex = 1;
            if (senderAccountNumber != null) {
                statement.setInt(paramIndex++, senderAccountNumber);
            }
            if (receiverAccountNumber != null) {
                statement.setInt(paramIndex++, receiverAccountNumber);
            }
            if (fromDate != null && !fromDate.isEmpty()) {
                statement.setDate(paramIndex++, java.sql.Date.valueOf(fromDate));
            }
            if (toDate != null && !toDate.isEmpty()) {
                statement.setDate(paramIndex++, java.sql.Date.valueOf(toDate));
            }

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int sender = resultSet.getInt("sender_account_number");
                    int receiver = resultSet.getInt("receiver_account_number");
                    String date = resultSet.getString("date_of_transaction");
                    String type = resultSet.getString("transaction_type");
                    double amount = resultSet.getDouble("transaction_amount");
                    Transaction transaction = new Transaction(sender, receiver, date, type, amount);
                    transactions.add(transaction);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }



    

	public List<Transaction> getPassbook(String email) throws SQLException {
	    List<Transaction> transactions = new ArrayList<>();
	    Connection connection = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;

	    try {
	        connection = datasource.getConnection();
	        String query = "select * from accounts a join customer c on c.customer_id=a.customer_id join transactions t on t.sender_account_number=a.account_number or t.receiver_account_number=a.account_number where c.email_id=?";

	        preparedStatement = connection.prepareStatement(query);
	        preparedStatement.setString(1, email);

	        resultSet = preparedStatement.executeQuery();
	        String transactionType = null;
	        while (resultSet.next()) {
	            int transactionNumber = resultSet.getInt("transaction_number");
	            int senderAccountNumber = resultSet.getInt("sender_account_number");
	            int receiverAccountNumber = resultSet.getInt("receiver_account_number");
	            int AccountNumber = resultSet.getInt("account_number");
	            if(AccountNumber==senderAccountNumber) {
	            	transactionType="Debited";
	            }
	            if(AccountNumber==receiverAccountNumber) {
	            	transactionType="Credited";
	            }
	            double transactionAmount = resultSet.getDouble("transaction_amount");
	            String dateOfTransaction = resultSet.getString("date_of_transaction");

	            Transaction transaction = new Transaction(transactionNumber, senderAccountNumber, receiverAccountNumber, dateOfTransaction, transactionType, transactionAmount);
	            transactions.add(transaction);
	        }
	    } finally {
	        if (resultSet != null) {
	            resultSet.close();
	        }
	        if (preparedStatement != null) {
	            preparedStatement.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }

	    return transactions;
	}

	public CustomerDao() {
		super();
	}

	 public boolean newTransaction(String email, int receiverAccountNumber, double amount) {
	        Connection conn = null;
	        PreparedStatement st = null;
	        PreparedStatement st2 = null;
	        PreparedStatement st3 = null;
	        PreparedStatement st4 = null;
	        PreparedStatement st5 = null;
	        ResultSet rs = null;
	        ResultSet rs2 = null;
	        boolean transactionSuccess = false;

	        try {
	            conn = datasource.getConnection();
	            conn.setAutoCommit(false); 

	            
	            System.out.println("Starting transaction for email: " + email + ", receiver: " + receiverAccountNumber + ", amount: " + amount);

	            String query1 = "SELECT a.account_number, a.balance FROM accounts a JOIN customer c ON c.customer_id = a.customer_id WHERE c.email_id = ?";
	            st = conn.prepareStatement(query1);
	            st.setString(1, email);
	            rs = st.executeQuery();

	            if (rs.next()) {
	                int senderAccountNumber = rs.getInt("account_number");
	                double senderBalance = rs.getDouble("balance");
	                System.out.println("Sender account number: " + senderAccountNumber + ", balance: " + senderBalance);

	                if (senderBalance >= amount) {
	                    String query2 = "SELECT balance FROM accounts WHERE account_number = ?";
	                    st2 = conn.prepareStatement(query2);
	                    st2.setInt(1, receiverAccountNumber);
	                    rs2 = st2.executeQuery();

	                    if (rs2.next()) {
	                        double receiverBalance = rs2.getDouble("balance");
	                        System.out.println("Receiver balance: " + receiverBalance);

	                        String updateReceiverQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
	                        st3 = conn.prepareStatement(updateReceiverQuery);
	                        st3.setDouble(1, receiverBalance + amount);
	                        st3.setInt(2, receiverAccountNumber);
	                        st3.executeUpdate();
	                        System.out.println("Updated receiver balance.");

	                        String updateSenderQuery = "UPDATE accounts SET balance = ? WHERE account_number = ?";
	                        st4 = conn.prepareStatement(updateSenderQuery);
	                        st4.setDouble(1, senderBalance - amount);
	                        st4.setInt(2, senderAccountNumber);
	                        st4.executeUpdate();
	                        System.out.println("Updated sender balance.");

	                        String insertTransactionQuery = "INSERT INTO transactions (sender_account_number, receiver_account_number, transaction_type, transaction_amount) VALUES (?, ?, ?, ?)";
	                        st5 = conn.prepareStatement(insertTransactionQuery);
	                        st5.setInt(1, senderAccountNumber);
	                        st5.setInt(2, receiverAccountNumber);
	                        st5.setString(3, "Transfer");
	                        st5.setDouble(4, amount);
	                        st5.executeUpdate();
	                        System.out.println("Inserted transaction record.");

	                        conn.commit(); 
	                        transactionSuccess = true;
	                        System.out.println("Transaction committed.");
	                    } else {
	                        System.out.println("Receiver account does not exist.");
	                    }
	                } else {
	                    System.out.println("Insufficient balance.");
	                }
	            } else {
	                System.out.println("Sender account does not exist.");
	            }
	        } catch (SQLException e) {
	            if (conn != null) try { conn.rollback(); } catch (SQLException ex) { ex.printStackTrace(); } // Rollback on error
	            e.printStackTrace();
	        } finally {
	            if (rs != null) try { rs.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (rs2 != null) try { rs2.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (st != null) try { st.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (st2 != null) try { st2.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (st3 != null) try { st3.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (st4 != null) try { st4.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (st5 != null) try { st5.close(); } catch (SQLException e) { e.printStackTrace(); }
	            if (conn != null) try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	        }
	        return transactionSuccess;
	    }
	
	
		public boolean editProfile(Customer customer) throws SQLException {
		    try {
		      Connection conn = datasource.getConnection();
		      String query = "update customer set first_name=? ,last_name=? , password=? where email_id=?";
		      PreparedStatement p = conn.prepareStatement(query);
		      p.setString(1, customer.getFirst_name());
		      p.setString(2, customer.getLast_name());
		      p.setString(3, customer.getPassword());
		      p.setString(4, customer.getEmail());

		      System.out.println(customer.getFirst_name());
		      System.out.println(customer.getLast_name());
		      System.out.println(customer.getPassword());
		      System.out.println(customer.getEmail());

		      int rs = p.executeUpdate();
		      return rs == 1 ? true : false;

		    } catch (SQLException e) {
		      e.printStackTrace();
		    }
		    return false;

	}

		public static boolean validateAdmin(String username, String password) {
		    try (Connection connection = DataBaseUtil.getConnection();
	        		) {
	        	String VALIDATE_CUSTOMER_QUERY = "SELECT * FROM admin WHERE email_id = ? AND passsword = ?";
	            PreparedStatement statement = connection.prepareStatement(VALIDATE_CUSTOMER_QUERY);
	            statement.setString(1, username);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();

	            if (resultSet.next()) {
	               return true;
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	     
	    
			return false;
		}


	}


	

	


	
		
		
	    


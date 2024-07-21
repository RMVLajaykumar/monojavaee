package com.monocept.entry;

public class Account {
    private int customer_id;
    private int account_number;
    private double balance;

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAccount_number() {
        return account_number;
    }

    public void setAccount_number(int account_number) {
        this.account_number = account_number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(int customer_id, int account_number, double balance) {
        super();
        this.customer_id = customer_id;
        this.account_number = account_number;
        this.balance = balance;
    }

    public Account(int account_number, double balance) {
        super();
        this.account_number = account_number;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [customer_id=" + customer_id + ", account_number=" + account_number + ", balance=" + balance
                + "]";
    }
}

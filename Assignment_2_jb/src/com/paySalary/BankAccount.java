package com.paySalary;

enum AccountType {
    SAVINGS, CURRENT
}

public class BankAccount {
    private AccountType accountType;
    private int accountNumber;
    private double currentBalance;
    private String branchName;

    public BankAccount(AccountType accountType, int accountNumber,
                       double currentBalance, String branchName) {
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        this.branchName = branchName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance += currentBalance;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void addBalance(double balance) {
        this.currentBalance += balance;
    }

    public void withdrawBalance(double balance) {
        this.currentBalance -= balance;
    }
}

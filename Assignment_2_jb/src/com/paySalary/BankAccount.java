package com.paySalary;

import java.math.BigDecimal;

enum AccountType {
    SAVINGS, CURRENT
}

public class BankAccount {

    private AccountType accountType;
    private int accountNumber;
    private BigDecimal currentBalance;
    private String branchName;

    public BankAccount(AccountType accountType, int accountNumber,
                       BigDecimal currentBalance, String branchName) {
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

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = this.currentBalance.add(currentBalance);
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void addBalance(BigDecimal balance) {
        this.currentBalance = this.currentBalance.add(balance);
    }

    public void withdrawBalance(BigDecimal balance) {
        this.currentBalance = this.currentBalance.subtract(balance);
    }
}

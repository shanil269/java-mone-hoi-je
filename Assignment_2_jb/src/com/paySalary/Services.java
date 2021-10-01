package com.paySalary;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Services {

    static void addBalanceToCompany(BankAccount bankAccount) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Transfer balance to Add in Company Account: ");
            double balance = scanner.nextDouble();
            bankAccount.addBalance(balance);
        } catch (InputMismatchException inputException) {
            System.out.println("Not a valid input for transferring balance!");
        }
    }

    static void setLowestSalary(Company company) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Set lowest grade's basic salary: ");
            double salary = scanner.nextDouble();
            company.setLowestSalary(salary);
        } catch (InputMismatchException inputException) {
            System.out.println("Not a valid input as Salary!");
        }
    }

    static void fundTransfer(Company company, BankAccount bankAccount) {
        if (company.getTotalRequiredMonthlySalary() > bankAccount.getCurrentBalance()) {
            System.out.println("Can't Transfer Fun, Insufficient Balance.");
        } else {
            bankAccount.withdrawBalance(company.getTotalRequiredMonthlySalary());
            company.setTotalPaidSalary(company.getTotalPaidSalary() + company.getTotalRequiredMonthlySalary());
            for (Employee employee : company.getEmployees()) {
                employee.getBankAccount().setCurrentBalance(employee.getSalary());
            }
            System.out.println("Successfully Transferred Funds!!");
        }
    }

    static void printEmployeeInfo(Company company) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/paySalary/resources/EmployeeInfo.txt"));
            for (Employee employee : company.getEmployees()) {
                writer.write(employee.getName() + " " + employee.getSalary() + " " + employee.getGrade() + "\n");
            }
            System.out.println("Successfully Printed, Please Check 'EmployeesInfo.txt' File!");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Some problem may occur working with files!");
        }
    }

    static void printTotalPaidSalaryAndCurrentBalance(Company company) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/com/paySalary/resources/TotalPaidSalaryAndCurrentBalance.txt"));
            writer.write("Total Paid Salary: " + company.getTotalPaidSalary() + " And Company's Current Balance: " + company.getCompanyAccount().getCurrentBalance() + "\n");
            System.out.println("Successfully Printed, Please Check 'TotalPaidSalaryAndCurrentBalance.txt' File!");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Some problem may occur working with files!");
        }
    }
}


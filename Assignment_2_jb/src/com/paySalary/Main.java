package com.paySalary;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Company company = new Company();
            BankAccount bankAccount = company.getCompanyAccount();

            Scanner scanner = new Scanner(System.in);
            System.out.println("\nWelcome to salary tracking system\n");
            while (true) {
                System.out.println("Choose options:\n");
                System.out.println("Press 1 to see company's current balance.");
                System.out.println("Press 2 to add fund into company's bank account.");
                System.out.println("Press 3 to set basic salary to lowest grade.");
                System.out.println("Press 4 to fund transfer to employees.");
                System.out.println("Press 5 to print employee information - name, salary, rank in a file.");
                System.out.println("Press 6 to print total paid salary and company's current balance in a file.");
                System.out.println("Press 7 to exit from this system.");
                int options = scanner.nextInt();
                if (options == 7) {
                    break;
                } else {
                    switch (options) {
                        case 1:
                            System.out.println("\n" + bankAccount.getCurrentBalance());
                            break;
                        case 2:
                            System.out.println();
                            Services.addBalanceToCompany(bankAccount);
                            break;
                        case 3:
                            System.out.println();
                            Services.setLowestSalary(company);
                            break;
                        case 4:
                            System.out.println();
                            Services.fundTransfer(company, bankAccount);
                            break;
                        case 5:
                            System.out.println();
                            Services.printEmployeeInfo(company);
                            break;
                        case 6:
                            System.out.println();
                            Services.printTotalPaidSalaryAndCurrentBalance(company);
                            break;
                        default:
                            System.out.println("Not a option to do something, Try again !!");
                            break;
                    }
                }
            }
        } catch (InputMismatchException inputException) {
            System.out.println("Only integer value is applicable as options!");
        } catch (Exception ex) {
            System.out.println("Search for irregularities in public void main function: \n" + ex);
        }
    }

//    private static void addBalanceToCompany(BankAccount bankAccount) {
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Transfer balance to Add in Company Account: ");
//            double balance = scanner.nextDouble();
//            bankAccount.addBalance(balance);
//        } catch (InputMismatchException inputException) {
//            System.out.println("Not a valid input for transferring balance!");
//        }
//    }
//
//    private static void setLowestSalary(Company company) {
//        try {
//            Scanner scanner = new Scanner(System.in);
//            System.out.print("Set lowest grade's basic salary: ");
//            double salary = scanner.nextDouble();
//            company.setLowestSalary(salary);
//        } catch (InputMismatchException inputException) {
//            System.out.println("Not a valid input as Salary!");
//        }
//    }
//
//    private static void fundTransfer(Company company, BankAccount bankAccount) {
//        if (bankAccount.getCurrentBalance() == 0.0) {
//            System.out.println("Add Fund, Company's Current Balance is 0.0");
//        } else if (company.getTotalRequiredMonthlySalary() == 0.0) {
//            System.out.println("Set Basic Salary for Lowest Grade Employee, Not Set Yet !!");
//        } else if (company.getTotalRequiredMonthlySalary() > bankAccount.getCurrentBalance()) {
//            System.out.println("Can't Transfer Fun, Insufficient Balance.");
//        } else {
//            bankAccount.withdrawBalance(company.getTotalRequiredMonthlySalary());
//            company.setTotalPaidSalary(company.getTotalPaidSalary() + company.getTotalRequiredMonthlySalary());
//            for (Employee employee : company.getEmployees()) {
//                employee.getBankAccount().setCurrentBalance(employee.getSalary());
//            }
//            System.out.println("Successfully Transferred Funds!!");
//        }
//    }
//
//    private static void printEmployeeInfo(Company company) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("." + "EmployeeInfo.txt"));
//            for (Employee employee : company.getEmployees()) {
//                writer.write(employee.getName() + " " + employee.getSalary() + " " + employee.getGrade() + "\n");
//            }
//            System.out.println("Successfully Printed, Please Check 'EmployeesInfo.txt' File!");
//            writer.close();
//        } catch (IOException ex) {
//            System.out.println("Some problem may occur working with files!");
//        }
//    }
//
//    private static void printTotalPaidSalaryAndCurrentBalance(Company company) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter("." + "TotalPaidSalaryAndCurrentBalance.txt"));
//            writer.write("Total Paid Salary: " + company.getTotalPaidSalary() + " And Company's Current Balance: " + company.getCompanyAccount().getCurrentBalance() + "\n");
//            System.out.println("Successfully Printed, Please Check 'TotalPaidSalaryAndCurrentBalance.txt' File!");
//            writer.close();
//        } catch (IOException ex) {
//            System.out.println("Some problem may occur working with files!");
//        }
//    }
}

package com.paySalary;

import java.util.InputMismatchException;
import java.util.Scanner;

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
}

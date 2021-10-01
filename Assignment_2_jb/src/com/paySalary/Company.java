package com.paySalary;

import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;
    private String CompanyName;
    private double lowestSalary;
    private BankAccount companyAccount;
    private double totalRequiredMonthlySalary;
    private double totalPaidSalary;
    private static final double salaryIncrease = 5000.0;
    private static final double medicalAllowance = 0.15;
    private static final double houseAllowance = 0.2;

    public Company() {
        this.CompanyName = "BA";
        this.lowestSalary = 0.0;
        this.companyAccount = new BankAccount(AccountType.CURRENT, 001,
                0.0, "Miyazaki");
        this.totalRequiredMonthlySalary = 0.0;
        this.totalPaidSalary = 0.0;
        this.initEmployees();
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public double getTotalRequiredMonthlySalary() {
        return totalRequiredMonthlySalary;
    }

    public void setTotalRequiredMonthlySalary(double totalRequiredMonthlySalary) {
        this.totalRequiredMonthlySalary = totalRequiredMonthlySalary;
    }

    public double getTotalPaidSalary() {
        return totalPaidSalary;
    }

    public void setTotalPaidSalary(double totalPaidSalary) {
        this.totalPaidSalary = totalPaidSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(double lowestSalary) {
        this.lowestSalary = lowestSalary;
        this.setEmployeeSalaries();
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public BankAccount getCompanyAccount() {
        return companyAccount;
    }

    public void setCompanyAccount(BankAccount companyAccount) {
        this.companyAccount = companyAccount;
    }

    private void initEmployees() {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee("ken", Grades.GRADE_ONE, "House No: 1, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 111, 900,
                "Miyazaki branch")));
        this.employees.add(new Employee("Dai", Grades.GRADE_TWO, "House No: 2, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 112, 800,
                "Miyazaki branch")));
        this.employees.add(new Employee("Nichi", Grades.GRADE_THREE, "House No: 3, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 113, 700,
                "Miyazaki branch")));
        this.employees.add(new Employee("Takeo", Grades.GRADE_THREE, "House No: 4, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 114, 600,
                "Miyazaki branch")));
        this.employees.add(new Employee("Uzawa", Grades.GRADE_FOUR, "House No: 5, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 115, 500,
                "Miyazaki branch")));
        this.employees.add(new Employee("Nagasawa", Grades.GRADE_FOUR, "House No: 6, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 116, 400,
                "Miyazaki branch")));
        this.employees.add(new Employee("Suzuki", Grades.GRADE_FIVE, "House No: 7, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 117, 300,
                "Miyazaki branch")));
        this.employees.add(new Employee("Karuri", Grades.GRADE_FIVE, "House No: 8, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 118, 200,
                "Miyazaki branch")));
        this.employees.add(new Employee("Koseki", Grades.GRADE_SIX, "House No: 9, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 119, 100,
                "Miyazaki branch")));
        this.employees.add(new Employee("Nakamura", Grades.GRADE_SIX, "House No: 10, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 120, 50,
                "Miyazaki branch")));
    }

    private void setEmployeeSalaries() {
        double basic;
        double grossSalary;
        for (Employee employee : this.employees) {
            Grades salaryGrades = employee.getGrade();
            basic = (this.getLowestSalary() + (salaryIncrease * salaryGrades.number));
            grossSalary = basic + (basic * houseAllowance) + (basic * medicalAllowance);
            this.totalRequiredMonthlySalary += grossSalary;
            employee.setSalary(grossSalary);
        }
    }
}

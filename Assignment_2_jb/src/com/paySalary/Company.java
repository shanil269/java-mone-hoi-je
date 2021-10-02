package com.paySalary;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Company {
    private ArrayList<Employee> employees;
    private String CompanyName;
    private BigDecimal lowestSalary;
    private BankAccount companyAccount;
    private BigDecimal totalRequiredMonthlySalary;
    private BigDecimal totalPaidSalary;
    private static final BigDecimal salaryIncrease = BigDecimal.valueOf(5000);
    private static final BigDecimal medicalAllowance = BigDecimal.valueOf(0.15);
    private static final BigDecimal houseAllowance = BigDecimal.valueOf(0.2);

    public Company() {
        this.CompanyName = "BA";
        this.lowestSalary = BigDecimal.valueOf(0);
        this.companyAccount = new BankAccount(AccountType.CURRENT, 001,
                BigDecimal.valueOf(0), "Miyazaki");
        this.totalRequiredMonthlySalary = BigDecimal.valueOf(0);
        this.totalPaidSalary = BigDecimal.valueOf(0);
        this.initEmployees();
    }

    public BigDecimal getTotalRequiredMonthlySalary() {
        return totalRequiredMonthlySalary;
    }

    public void setTotalRequiredMonthlySalary(BigDecimal totalRequiredMonthlySalary) {
        this.totalRequiredMonthlySalary = totalRequiredMonthlySalary;
    }

    public BigDecimal getTotalPaidSalary() {
        return totalPaidSalary;
    }

    public void setTotalPaidSalary(BigDecimal totalPaidSalary) {
        this.totalPaidSalary = totalPaidSalary;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public BigDecimal getLowestSalary() {
        return lowestSalary;
    }

    public void setLowestSalary(BigDecimal lowestSalary) {
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
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 111, BigDecimal.valueOf(900),
                "Miyazaki branch")));
        this.employees.add(new Employee("Dai", Grades.GRADE_TWO, "House No: 2, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 112, BigDecimal.valueOf(800),
                "Miyazaki branch")));
        this.employees.add(new Employee("Nichi", Grades.GRADE_THREE, "House No: 3, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 113, BigDecimal.valueOf(700),
                "Miyazaki branch")));
        this.employees.add(new Employee("Takeo", Grades.GRADE_THREE, "House No: 4, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 114, BigDecimal.valueOf(600),
                "Miyazaki branch")));
        this.employees.add(new Employee("Uzawa", Grades.GRADE_FOUR, "House No: 5, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 115, BigDecimal.valueOf(500),
                "Miyazaki branch")));
        this.employees.add(new Employee("Nagasawa", Grades.GRADE_FOUR, "House No: 6, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 116, BigDecimal.valueOf(400),
                "Miyazaki branch")));
        this.employees.add(new Employee("Suzuki", Grades.GRADE_FIVE, "House No: 7, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 117, BigDecimal.valueOf(300),
                "Miyazaki branch")));
        this.employees.add(new Employee("Karuri", Grades.GRADE_FIVE, "House No: 8, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 118, BigDecimal.valueOf(200),
                "Miyazaki branch")));
        this.employees.add(new Employee("Koseki", Grades.GRADE_SIX, "House No: 9, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 119, BigDecimal.valueOf(100),
                "Miyazaki branch")));
        this.employees.add(new Employee("Nakamura", Grades.GRADE_SIX, "House No: 10, Road No: 3, Tachibana, Miyazaki",
                this.lowestSalary, new BankAccount(AccountType.SAVINGS, 120, BigDecimal.valueOf(50),
                "Miyazaki branch")));
    }

    private void setEmployeeSalaries() {
        BigDecimal basic;
        BigDecimal grossSalary;
        for (Employee employee : this.employees) {
            Grades salaryGrades = employee.getGrade();
            basic = (this.getLowestSalary().add(salaryIncrease.multiply(BigDecimal.valueOf(salaryGrades.number))));
            grossSalary = basic.add(basic.multiply(houseAllowance)).add((basic.multiply(medicalAllowance)));
            this.totalRequiredMonthlySalary = this.totalRequiredMonthlySalary.add(grossSalary);
            employee.setSalary(grossSalary);
        }
    }
}

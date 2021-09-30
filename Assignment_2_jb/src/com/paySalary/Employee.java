package com.paySalary;

enum Grades {
    GRADE_ONE(5),
    GRADE_TWO(4),
    GRADE_THREE(3),
    GRADE_FOUR(2),
    GRADE_FIVE(1),
    GRADE_SIX(0);
    public final int number;

    Grades(int i) {
        this.number = i;
    }
}

public class Employee {
    private String name;
    private Grades grade;
    private String address;
    private double salary;
    private BankAccount bankAccount;

    public Employee(String name, Grades grade, String address, double salary, BankAccount bankAccount) {
        this.name = name;
        this.grade = grade;
        this.address = address;
        this.salary = salary;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grades getGrade() {
        return grade;
    }

    public void setGrade(Grades grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
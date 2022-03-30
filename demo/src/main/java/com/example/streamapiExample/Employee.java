package com.example.streamapiExample;

public class Employee {


    private String employeeName;
    private long employeeSalary;

    public Employee(String employeeName, long employeeSalary) {
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeName() {
        return this.employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public long getEmployeeSalary() {
        return this.employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    @Override
    public String toString() {
        return "{" +
            " employeeName='" + getEmployeeName() + "'" +
            ", employeeSalary='" + getEmployeeSalary() + "'" +
            "}";
    }

   

    
}

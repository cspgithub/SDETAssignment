package com.example.streamapiExample;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public List<Employee> evaluateTaxPayers() {

        return EmployeeDAO.getEmployes().stream().filter(emp -> emp.getEmployeeSalary() >= 500000)
                .collect(Collectors.toList());

    }

    public static void main(String[] args) {

        System.out.println(new TaxService().evaluateTaxPayers());

    }

}

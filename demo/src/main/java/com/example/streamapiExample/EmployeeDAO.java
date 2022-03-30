package com.example.streamapiExample;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    public static List<Employee> getEmployes() {

        List<Employee> list = new ArrayList<>();

        list.add(new Employee("Shekhar", 500000));
        list.add(new Employee("Rohit", 700000));
        list.add(new Employee("Neeraj", 50000000));
        list.add(new Employee("Prem", 100000));

        return list;

    }

}

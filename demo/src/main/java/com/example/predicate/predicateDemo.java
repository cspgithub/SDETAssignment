package com.example.predicate;

import java.util.HashMap;

import java.util.Map;

public class predicateDemo {

    public static void main(String[] args) {

     /*    List<Integer> numbers = Arrays.asList(23, 4, 5, 6, 67, 7);
        // first filter and then accept
        numbers.stream().filter((number) -> number % 2 == 0).forEach(number -> System.out.println(number)); */


        Map<Integer,Object> students = new HashMap<>();
        students.put(2, "shekhar");
        students.put(45, "mot llaowed");
        students.put(6, "ram");

        students.entrySet().stream().filter(k->k.getKey()%2==0).forEach(t->System.out.println(t));
    }

}

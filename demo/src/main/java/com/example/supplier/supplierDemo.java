package com.example.supplier;

import java.util.Arrays;
import java.util.List;


public class supplierDemo {
    

    public static void main(String[] args) {
      /*  Supplier<String> spl = ()->"string supplier lambda";

        System.out.println(spl.get());   */



        List<String> name = Arrays.asList("a","b");

        System.out.println(name.stream().findAny().orElseGet(()->"csp"));
    }
}

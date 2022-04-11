package com.example.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class listPractice {

    // collection framework

    /*
     * collection interfacce [ds ko handle krne ke liye list interface,set,map aur
     * usske baas class
     * jinke objects bana ke ds ko implemet kr sjte hai]
     */

    /* list */ // ds conyinus fashion mai ralh skte ho

    // ArrayList ----normal arrays but dyamic hot hai

    public static void main(String[] args) {

        ArrayList<String> students = new ArrayList<String>();
        students.add("rohan");// will create interanal array of size 10
        // n +n/2+1 10=5=1=16 will copy all old array items in new array and will
        // inseryt item in 11th position

        // will add item at last of the list

        // System.out.println(students);

        students.add("rohan");
        // System.out.println(students);
        // students.add(0, "rohan");
        ArrayList<String> newstudents = new ArrayList<String>();
        newstudents.add("rohannew");
        students.addAll(newstudents);
        // System.out.println("get item at index 1 :" + students.get(1));
        // students.remove(1);
        System.out.println("final list :" + students);
        students.remove(String.valueOf("rohan"));
        System.out.println("final list after removal :" + students);
        students.set(1, "setrohannew");
        System.out.println("update the list :" + students);
        System.out.println("conatins element or not :" + students.contains("rohan"));

        Iterator<String> itStudents = students.iterator();
        while(itStudents.hasNext()){

        System.out.println("iterate using iterator:  " + itStudents.next());

        }
    }

}

package com.example.comaparatorLambda;

import java.util.ArrayList;
import java.util.List;

public class BooksAPIDAO {


    public List<Books> getBooksList() {

        List<Books> books = new ArrayList<>();
        books.add(new Books(1200, "java"));
        books.add(new Books(12, "Ajava"));
        books.add(new Books(100, "Bjava"));
        books.add(new Books(1770, "Xjava"));
        return books;  
    }
    
}

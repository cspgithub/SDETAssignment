package com.example.comaparatorLambda;

public class Books {

    private Integer bookID;
    private String bookName;

    public Books(Integer bookID, String bookName) {
        this.bookID = bookID;
        this.bookName = bookName;
    }

    public Integer getBookID() {
        return this.bookID;
    }

    public void setBookID(Integer bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return this.bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return "{" +
            " bookID='" + getBookID() + "'" +
            ", bookName='" + getBookName() + "'" +
            "}";
    }

   

   
    
}

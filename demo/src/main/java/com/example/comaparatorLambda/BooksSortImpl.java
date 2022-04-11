package com.example.comaparatorLambda;

import java.util.Collections;

import java.util.List;

public class BooksSortImpl {

    public List<Books> getSortedOrderListBooks() {

        /*
         * @Override
         * public int compare(Books bk1, Books bk2) {
         * return bk2.getBookName().compareTo(bk1.getBookName());
         * }
         */
        List<Books> unsortedOder = new BooksAPIDAO().getBooksList();
        Collections.sort(unsortedOder, (bk1, bk2) -> bk2.getBookID().compareTo(bk1.getBookID()));
        return unsortedOder;
    }

    public static void main(String[] args) {

        System.out.println(new BooksSortImpl().getSortedOrderListBooks());


    }
    /**
     * mycomaptor logic ffor function
     * its functional interface as it contains only one abstarct fucntion/method
     */
    /*
     * class myComparator implements Comparator<Books> {
     * 
     * @Override
     * public int compare(Books bk1, Books bk2) {
     * 
     * return bk1.getBookName().compareTo(bk2.getBookName());
     * }
     * 
     * 
     * }
     */

}
